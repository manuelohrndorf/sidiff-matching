package org.sidiff.common.chartsutil;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.birt.chart.api.ChartEngine;
import org.eclipse.birt.chart.device.EmptyUpdateNotifier;
import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.device.IDisplayServer;
import org.eclipse.birt.chart.device.IImageMapEmitter;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.factory.GeneratedChartState;
import org.eclipse.birt.chart.factory.IGenerator;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.ChartWithoutAxes;
import org.eclipse.birt.chart.model.attribute.AxisType;
import org.eclipse.birt.chart.model.attribute.Bounds;
import org.eclipse.birt.chart.model.attribute.ChartDimension;
import org.eclipse.birt.chart.model.attribute.IntersectionType;
import org.eclipse.birt.chart.model.attribute.LegendItemType;
import org.eclipse.birt.chart.model.attribute.MarkerType;
import org.eclipse.birt.chart.model.attribute.Position;
import org.eclipse.birt.chart.model.attribute.TickStyle;
import org.eclipse.birt.chart.model.attribute.impl.BoundsImpl;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
import org.eclipse.birt.chart.model.component.Axis;
import org.eclipse.birt.chart.model.component.Series;
import org.eclipse.birt.chart.model.component.impl.AxisImpl;
import org.eclipse.birt.chart.model.component.impl.SeriesImpl;
import org.eclipse.birt.chart.model.data.BaseSampleData;
import org.eclipse.birt.chart.model.data.DataFactory;
import org.eclipse.birt.chart.model.data.SampleData;
import org.eclipse.birt.chart.model.data.SeriesDefinition;
import org.eclipse.birt.chart.model.data.impl.NumberDataSetImpl;
import org.eclipse.birt.chart.model.data.impl.SeriesDefinitionImpl;
import org.eclipse.birt.chart.model.data.impl.TextDataSetImpl;
import org.eclipse.birt.chart.model.impl.ChartWithAxesImpl;
import org.eclipse.birt.chart.model.impl.ChartWithoutAxesImpl;
import org.eclipse.birt.chart.model.layout.Legend;
import org.eclipse.birt.chart.model.layout.Plot;
import org.eclipse.birt.chart.model.type.LineSeries;
import org.eclipse.birt.chart.model.type.PieSeries;
import org.eclipse.birt.chart.model.type.impl.AreaSeriesImpl;
import org.eclipse.birt.chart.model.type.impl.BarSeriesImpl;
import org.eclipse.birt.chart.model.type.impl.LineSeriesImpl;
import org.eclipse.birt.chart.model.type.impl.PieSeriesImpl;
import org.eclipse.birt.core.framework.PlatformConfig;

/**
 * Utility class for creating charts for logged values
 * 
 * @author reuling
 */
public class ChartsUtil {

	public enum SeriesWithAxesType {
		BarChart, LineChart, AreaChart;
	}

	public enum SeriesWithoutAxesType {
		PieChart;
	}

	private static ChartsUtil instance;

	// device renderers for dv.SWT, dv.PNG, dv.JPG
	// dv.PDF, dv.SVG, dv.SWING, dv.PNG24, div.BMP
	private static final String RENDERER = "dv.SVG";

	private static final Integer WIDTH = 800;
	private static final Integer HEIGHT = 800;

	/**
	 * The swing rendering device
	 */
	private IDeviceRenderer dRenderer = null;
	private IDisplayServer dServer = null;
	private IGenerator gr = null;

	/**
	 * Method for singleton instance of Chartsutil
	 * 
	 * @return current global instance
	 */
	public static ChartsUtil getInstance() {
		if (instance == null)
			instance = new ChartsUtil(RENDERER);
		return instance;
	}

	/**
	 * Constructor
	 * 
	 * @param renderer
	 *            used for rendering
	 */
	private ChartsUtil(String renderer) {

		PlatformConfig pf = new PlatformConfig();

		// Returns a singleton instance of the Chart Engine
		ChartEngine ce = ChartEngine.instance(pf);
		// Returns a singleton instance of the Generator
		gr = ce.getGenerator();

		try {
			dRenderer = ce.getRenderer(renderer);
		} catch (ChartException e) {
			e.printStackTrace();
		}
		dServer = dRenderer.getDisplayServer();
	}

	/**
	 * Writing a given chart into a file
	 * 
	 * @param filename
	 *            to save the chart under
	 * @param chart
	 *            to write as file
	 */

	private void writeChartAsImage(String filename, Chart chart) {

		BufferedImage img = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_ARGB);
		Graphics g = img.getGraphics();

		Graphics2D g2d = (Graphics2D) g;

		// Look at IDeviceRenderer.java for all properties
		// like DPI_RESOLUTION
		// FILE_IDENTIFIER
		// FORMAT_IDENTIFIER
		// UPDATE_NOTIFIER
		dRenderer.setProperty(IDeviceRenderer.GRAPHICS_CONTEXT, g2d);
		dRenderer.setProperty(IDeviceRenderer.FILE_IDENTIFIER, filename); //$NON-NLS-1$

		// Set the bounds for the entire chart
		Bounds bo = BoundsImpl.create(0, 0, WIDTH, HEIGHT);
		bo.scale(72d / dRenderer.getDisplayServer().getDpiResolution());

		try {
			GeneratedChartState gcs = gr.build(dServer, chart, bo, null, null,
					null);
			// gcs.getRunTimeContext().setActionRenderer( new
			// MyActionRenderer());
			// have to have this line if you want the image map generated
			dRenderer.setProperty(IDeviceRenderer.UPDATE_NOTIFIER,
					new EmptyUpdateNotifier(chart, gcs.getChartModel()));

			gr.render(dRenderer, gcs);
			if(!RENDERER.equals("dv.SVG"))
				((IImageMapEmitter) dRenderer).getImageMap();

		} catch (ChartException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method for creating a chart with axes
	 * 
	 * @see{writeChartWithAxes}
	 * @param chartTitle
	 *            title of the chart
	 * @param xAxisLabel
	 *            label of xaxis
	 * @param threeD
	 *            whether the chart will be renderd in 3D
	 * @param transposed
	 *            whether the chart will be transposed
	 * @param stacked
	 *            Map describing if y axis should be stacked
	 * @param logarithmic
	 *            Map describing if y axis should use logarithmic scale
	 * @param percentage
	 *            Map describing if y axis should display percentage
	 * @param showLabels
	 *            Map describing if series should display labels
	 * @param measurementPoints
	 *            list of measurement points
	 * @param seriesType
	 *            Map assigning series types to series
	 * @param AxisTovalueMap
	 *            Map assigning series to y axes
	 * @return the constructed chart
	 */
	private ChartWithAxes createChartWithAxes(String chartTitle,
			String xAxisLabel, Boolean threeD, Boolean transposed,
			Map<String, Boolean> stacked, Map<String, Boolean> logarithmic,
			Map<String, Boolean> percentage,
			Map<String, Boolean> showLabels,
			ArrayList<String> measurementPoints,
			Map<String, SeriesWithAxesType> seriesType,
			Map<String, Map<String, Number[]>> AxisTovalueMap) {

		ChartWithAxes cwa = ChartWithAxesImpl.create();
		cwa.getBlock().setBackground(ColorDefinitionImpl.WHITE());
		cwa.getBlock().getOutline().setVisible(true);
		if (threeD)
			cwa.setDimension(ChartDimension.TWO_DIMENSIONAL_WITH_DEPTH_LITERAL);
		else
			cwa.setDimension(ChartDimension.TWO_DIMENSIONAL_LITERAL);

		cwa.getTitle().getLabel().getCaption().setValue(chartTitle);

		Plot p = cwa.getPlot();
		p.getClientArea().setBackground(ColorDefinitionImpl.WHITE());

		Legend lg = cwa.getLegend();
		lg.setItemType(LegendItemType.SERIES_LITERAL);

		SampleData sd = DataFactory.eINSTANCE.createSampleData();
		BaseSampleData sdBase = DataFactory.eINSTANCE.createBaseSampleData();
		sdBase.setDataSetRepresentation("");
		sd.getBaseSampleData().add(sdBase);
		cwa.setSampleData(sd);

		// X-Axis
		Axis xAxisPrimary = cwa.getPrimaryBaseAxes()[0];
		xAxisPrimary.setType(AxisType.TEXT_LITERAL);
		xAxisPrimary.getMajorGrid().setTickStyle(TickStyle.BELOW_LITERAL);
		xAxisPrimary.getOrigin().setType(IntersectionType.MIN_LITERAL);
		xAxisPrimary.getTitle().getCaption().setValue(xAxisLabel);
		xAxisPrimary.getTitle().setVisible(Boolean.TRUE);
		xAxisPrimary.setStaggered(Boolean.TRUE);

		// X-Series
		Series seMeasurements = SeriesImpl.create();
		seMeasurements.setDataSet(TextDataSetImpl.create(measurementPoints));
		SeriesDefinition sdX = SeriesDefinitionImpl.create();
		xAxisPrimary.getSeriesDefinitions().add(sdX);
		sdX.getSeries().add(seMeasurements);

		// Y-Axes
		Map<String, Axis> yaxes = new HashMap<String, Axis>();
		boolean firstAxis = true;
		for (String axis : AxisTovalueMap.keySet()) {
			Axis yAxis = null;
			if (firstAxis) {
				yAxis = cwa.getPrimaryOrthogonalAxis(xAxisPrimary);
				yAxis.getMajorGrid().setTickStyle(TickStyle.RIGHT_LITERAL);
				yAxis.setLabelPosition(Position.LEFT_LITERAL);
				yAxis.setTitlePosition(Position.LEFT_LITERAL);
				firstAxis = false;

			} else {
				yAxis = AxisImpl.create(Axis.ORTHOGONAL);
				yAxis.getMajorGrid().setTickStyle(TickStyle.LEFT_LITERAL);
				yAxis.setLabelPosition(Position.RIGHT_LITERAL);
				yAxis.setTitlePosition(Position.RIGHT_LITERAL);
			}
			if (logarithmic.get(axis))
				yAxis.setType(AxisType.LOGARITHMIC_LITERAL);
			else
				yAxis.setType(AxisType.LINEAR_LITERAL);
			yAxis.getTitle().getCaption().setValue(axis);
			yAxis.getTitle().setVisible(Boolean.TRUE);
			if (!firstAxis)
				xAxisPrimary.getAssociatedAxes().add(yAxis);
			yAxis.setPercent(percentage.get(axis));
			yaxes.put(axis, yAxis);
		}

		// Y Series
		for (String yaxis : yaxes.keySet()) {
			SeriesDefinition sdY = SeriesDefinitionImpl.create();	
			for (String series : AxisTovalueMap.get(yaxis).keySet()) {
				Series ser = null;
				SeriesWithAxesType type = seriesType.get(series);
				switch (type) {
				case BarChart:
					ser = BarSeriesImpl.create();
					ser.setLabelPosition(Position.INSIDE_LITERAL);
					break;
				case LineChart:
					ser = LineSeriesImpl.create();
					ser.setLabelPosition(Position.ABOVE_LITERAL);
					((LineSeries) ser).getLineAttributes().setThickness(1);
					((LineSeries) ser).getMarkers().get(0).setType(MarkerType.DIAMOND_LITERAL);
					break;
				case AreaChart:
					ser = AreaSeriesImpl.create();
					ser.setLabelPosition(Position.ABOVE_LITERAL);
					break;
				}
				ser.setSeriesIdentifier(series);
				ser.setDataSet(NumberDataSetImpl.create(AxisTovalueMap.get(
						yaxis).get(series)));
				ser.getLabel().setVisible(showLabels.get(series));
				ser.setStacked(stacked.get(yaxis));
				sdY.getSeries().add(ser);
			}
			yaxes.get(yaxis).getSeriesDefinitions().add(sdY);
		}

		cwa.setTransposed(transposed);

		return cwa;

	}

	/**
	 * Method for creating a chart without axes
	 * 
	 * @see{writeChartWithoutAxes}
	 * 
	 * @param chartTitle
	 *            title of the chart
	 * @param measurementTitle
	 *            title of measurement-type
	 * @param threeD
	 *            whether the chart will be renderd in 3D
	 * @param showLabels
	 *            whether labels should be displayed
	 * @param seriesType
	 *            Type of Series
	 * @param valueMap
	 *            Map containing categories and values
	 * @return the constructed chart
	 */
	private ChartWithoutAxes createChartWithoutAxes(String chartTitle,
			String measurementTitle, Boolean threeD, Boolean showLabels,
			SeriesWithoutAxesType seriesType, Map<String, Number> valueMap) {

		ChartWithoutAxes cwoa = ChartWithoutAxesImpl.create();
		cwoa.getBlock().setBackground(ColorDefinitionImpl.WHITE());
		cwoa.getBlock().getOutline().setVisible(true);
		if (threeD)
			cwoa.setDimension(ChartDimension.TWO_DIMENSIONAL_WITH_DEPTH_LITERAL);
		else
			cwoa.setDimension(ChartDimension.TWO_DIMENSIONAL_LITERAL);

		cwoa.getTitle().getLabel().getCaption().setValue(chartTitle);

		Plot p = cwoa.getPlot();
		p.getClientArea().setBackground(ColorDefinitionImpl.WHITE());

		Legend lg = cwoa.getLegend();
		lg.setItemType(LegendItemType.CATEGORIES_LITERAL);

		SampleData sd = DataFactory.eINSTANCE.createSampleData();
		BaseSampleData sdBase = DataFactory.eINSTANCE.createBaseSampleData();
		sdBase.setDataSetRepresentation("");
		sd.getBaseSampleData().add(sdBase);
		cwoa.setSampleData(sd);

		// Categories
		Series seCategory = SeriesImpl.create();
		seCategory.setDataSet(TextDataSetImpl.create(valueMap.keySet()));
		SeriesDefinition bd = SeriesDefinitionImpl.create();
		cwoa.getSeriesDefinitions().add(bd);
		bd.getSeries().add(seCategory);

		// Value Series
		Series ser = null;
		SeriesWithoutAxesType type = seriesType;
		switch (type) {
		case PieChart:
			ser = PieSeriesImpl.create();
			((PieSeries) ser).setClockwise(Boolean.TRUE);
			ser.setLabelPosition(Position.OUTSIDE_LITERAL);

			break;
		}

		ser.setSeriesIdentifier(measurementTitle);
		ser.getLabel().setVisible(showLabels);
		ser.setDataSet(NumberDataSetImpl.create(valueMap.values()));

		SeriesDefinition od = SeriesDefinitionImpl.create();
		bd.getSeriesDefinitions().add(od);
		od.getSeries().add(ser);

		return cwoa;

	}

	/**
	 * Method for creating a chart with axes
	 * 
	 * @param chartTitle
	 *            title of the chart
	 * @param xAxisLabel
	 *            label of xaxis
	 * @param threeD
	 *            whether the chart will be renderd in 3D
	 * @param transposed
	 *            whether the chart will be transposed
	 * @param stacked
	 *            Map describing if y axis should be stacked
	 * @param logarithmic
	 *            Map describing if y axis should use logarithmic scale
	 * @param percentage
	 *            Map describing if y axis should display percentage
	 * @param showLabels
	 *            Map describing if series should display labels
	 * @param measurementPoints
	 *            list of measurement points
	 * @param seriesType
	 *            Map assigning series types to series
	 * @param AxisTovalueMap
	 *            Map assigning series to y axes
	 * @param filename
	 * 			  filename to save the Chart under 
	 */
	public void writeChartWithAxes(String chartTitle, String xAxisLabel,
			Boolean threeD, Boolean transposed, Map<String, Boolean> stacked,
			Map<String, Boolean> logarithmic,
			Map<String, Boolean> percentage,
			Map<String, Boolean> showLabels,
			ArrayList<String> measurementPoints,
			Map<String, SeriesWithAxesType> seriesType,
			Map<String, Map<String, Number[]>> AxisTovalueMap, String filename) {

		// create chart
		ChartWithAxes cwa = createChartWithAxes(chartTitle, xAxisLabel, threeD,
				transposed, stacked, logarithmic, percentage, showLabels,
				measurementPoints, seriesType, AxisTovalueMap);

		// write chart to file
		writeChartAsImage(filename, cwa);
	}
	
	/**
	 * Method for writing a chart without axes to a imagefile
	 * 
	 * @param chartTitle
	 *            title of the chart
	 * @param measurementTitle
	 *            title of measurement-type
	 * @param threeD
	 *            whether the chart will be renderd in 3D
	 * @param showLabels
	 *            whether labels should be displayed
	 * @param seriesType
	 *            Type of Series
	 * @param valueMap
	 *            Map containing categories and values
	 * @param filename
	 * 			  filename to save the Chart under            
	 *            
	 */
	public void writeChartWithoutAxes(String chartTitle,
			String measurementTitle, Boolean threeD, Boolean showLabels,
			SeriesWithoutAxesType seriesType, Map<String, Number> valueMap,
			String filename) {
		
		// create chart
		ChartWithoutAxes cwoa = createChartWithoutAxes(chartTitle,
				measurementTitle, threeD, showLabels, seriesType, valueMap);

		// write chart to file
		writeChartAsImage(filename, cwoa);
	}

}
