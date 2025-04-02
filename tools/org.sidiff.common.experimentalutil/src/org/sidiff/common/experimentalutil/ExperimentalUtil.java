package org.sidiff.common.experimentalutil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.sidiff.common.chartsutil.ChartsUtil;
import org.sidiff.common.chartsutil.ChartsUtil.SeriesWithAxesType;
import org.sidiff.common.chartsutil.ChartsUtil.SeriesWithoutAxesType;
import org.sidiff.common.util.StatisticsUtil;
import org.sidiff.common.util.StatisticsUtil.StatisticType;

/**
 * Utility class for data management of @{StatisticsUtil}s.
 * Is can be used for experiments in conjunction with the @{StatisticsUtil} and
 * the @{ChartsUtil}
 * 
 * @author dreuling
 *
 */
public class ExperimentalUtil implements Serializable {

	private static final long serialVersionUID = 4920634384535018404L;
	
	private static final String LINE_SEPERATOR = System.getProperty("line.separator");

	
	//Global singleton
	private static ExperimentalUtil instance;
	
	//Name of the Experiment
	private String experimentName;
	
	//Date of the experiment
	private String date;
	
	//Map of all runs contained in this experiment
	private Map<String, StatisticsUtil> experimentRuns;
	
	/**
	 * Constructor
	 * @param experimentName name of the experiment
	 */
	private ExperimentalUtil(String experimentName) {
		this.experimentName = experimentName;		
		this.date = getTodayDateFormatted();
		this.experimentRuns = new HashMap<String, StatisticsUtil>();
	}
	
	/**
	 * Helper method for getting the current date
	 * @return today's date as formatted String
	 */
	private String getTodayDateFormatted(){
		Date date =  new Date();
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		return formatter.format(date);
	}
	
	/**
	 * Instance method for global instantiated ExperimentalUtil
	 * @param experimentName Name of the experiment
	 * @return global instance of this util
	 */
	public static ExperimentalUtil getInstance(String experimentName) {
		if (instance == null)
			instance = new ExperimentalUtil(experimentName);
		return instance;
	}
	
	/**
	 * Start an experimental run
	 * 
	 * @param experimentRun name of the run to start
	 */
	public void startRun(String experimentRun){
		
		assert (experimentRuns.get(experimentRun) == null) : 
			"ExperimentRun " + experimentRun + " already started!";
		StatisticsUtil.getInstance().reset();
		experimentRuns.put(experimentRun, StatisticsUtil.getInstance());
		
	}
	
	/**
	 * Stops an previously started experimental run
	 * 
	 * @param experimentRun name of the run to stop
	 */
	public void stopRun(String experimentRun) {
		
		assert (experimentRuns.get(experimentRun) != null) : 
			"ExperimentRun " + experimentRun + " has not been started!";
		
		//Clone StatisticsUtil and reset it afterwards
		experimentRuns.put(experimentRun, StatisticsUtil.copiedInstance(StatisticsUtil.getInstance()));
		StatisticsUtil.getInstance().reset();
	}
	
	/**
	 * Generates a chart with axes using many default values for a more clean
	 * execution and less parameters to configure
	 * 
	 * @param xAxisLabel label of x axis
	 * @param threeD whether to use 3D or 2D
	 * @param transposed whether to transpose the chart
	 * @param filename filename to save the chart under
	 */
	public void generateChartWithAxes(String xAxisLabel, Boolean threeD, Boolean transposed, String filename) {

		String yaxisSize = "Number of Elements";
		String yaxisTime = "TimeConsumption(ms)";
		String yaxisCount = "Iterations Counted";
		
		HashMap<String, Boolean> stackedAxes = new HashMap<String, Boolean>();
		stackedAxes.put(yaxisCount, true);
		stackedAxes.put(yaxisTime, true);
		stackedAxes.put(yaxisSize, true);

		HashMap<String, Boolean> logarithmicAxes = new HashMap<String, Boolean>();
		logarithmicAxes.put(yaxisCount, false);
		logarithmicAxes.put(yaxisTime, false);
		logarithmicAxes.put(yaxisSize, false);
		
		HashMap<String, Boolean> percentageAxes = new HashMap<String, Boolean>();
		percentageAxes.put(yaxisCount, false);
		percentageAxes.put(yaxisTime, false);
		percentageAxes.put(yaxisSize, false);
		
		HashMap<String, Boolean> showSeriesLabel = new HashMap<String, Boolean>();
		HashMap<String, SeriesWithAxesType> seriesTypes = new HashMap<String, SeriesWithAxesType>();
	
		for (String runs : experimentRuns.keySet()) {
			for (String series : experimentRuns.get(runs).getCountStatistic().keySet()) {
				showSeriesLabel.put(series, false);
				seriesTypes.put(series, SeriesWithAxesType.LineChart);
			}
			for (String series : experimentRuns.get(runs).getTimeStatistic().keySet()) {
				showSeriesLabel.put(series, false);
				seriesTypes.put(series, SeriesWithAxesType.BarChart);
			}
			for (String series : experimentRuns.get(runs).getSizeStatistic().keySet()) {
				showSeriesLabel.put(series, false);
				seriesTypes.put(series, SeriesWithAxesType.LineChart);
			}
		}
		
		
		HashMap<String, Map<String, Number[]>> axisTovalueMap = new HashMap<String, Map<String,Number[]>>();
		HashMap<String, Number[]> sizeValueMap = new HashMap<String, Number[]>();
		HashMap<String, Number[]> timeValueMap = new HashMap<String, Number[]>();
		HashMap<String, Number[]> countValueMap = new HashMap<String, Number[]>();

		// Sort exp Runs
		ArrayList<String> expRuns = new ArrayList<String>(experimentRuns.keySet());
		Collections.sort(expRuns);
		
		//All experiment runs need to have values for all series
		for (String countSer : experimentRuns.get(expRuns.get(0)).getCountStatistic().keySet()) {
			Number[] countValues = new Number[experimentRuns.size()];
			int i = 0;
			for(String run : expRuns){
				countValues[i] = (Number) experimentRuns.get(run).getCountStatistic().get(countSer);
				i++;
			}
			countValueMap.put(countSer, countValues);
		}
		for (String timeSer : experimentRuns.get(expRuns.get(0)).getTimeStatistic().keySet()) {
			Number[] timeValues = new Number[experimentRuns.size()];
			int i = 0;
			for(String run : expRuns){
				timeValues[i] = (Number) experimentRuns.get(run).getTimeStatistic().get(timeSer);
				i++;

			}
			timeValueMap.put(timeSer, timeValues);
		}
		for (String sizeSer : experimentRuns.get(expRuns.get(0)).getSizeStatistic().keySet()) {
			Number[] sizeValues = new Number[experimentRuns.size()];
			int i = 0;
			for(String run : expRuns){
				sizeValues[i] = (Number) experimentRuns.get(run).getSizeStatistic().get(sizeSer);
				i++;

			}
			sizeValueMap.put(sizeSer, sizeValues);
		}
		
	if(countValueMap.size() > 0)
		axisTovalueMap.put(yaxisCount, countValueMap);
	if(timeValueMap.size() > 0)
		axisTovalueMap.put(yaxisTime, timeValueMap);
	if( sizeValueMap.size() > 0)
		axisTovalueMap.put(yaxisSize, sizeValueMap);
		
		ChartsUtil.getInstance().writeChartWithAxes(experimentName, 
				xAxisLabel, threeD, transposed, stackedAxes, logarithmicAxes, percentageAxes, 
				showSeriesLabel, expRuns, seriesTypes, axisTovalueMap, filename);
		
	}
	
	/**
	 * Generates a chart with axes.
	 * Can be more fine tuned than the other method name equally.
	 * 
	 * @param xAxisLabel label of x axis
	 * @param threeD whether to use 3D or 2D
	 * @param transposed whether to transpose the chart
	 * @param showStatistic Map defining which statistics to include in the chart
	 * @param stacked Map defining for each statistic type whether to stack the series
	 * @param logarithmic Map defining for each statistic type whether to use logarithmic scale
	 * @param percentage Map defining for each statistic type whether to use percentage on y-axis
	 * @param showLabels Map defining for each statistic type whether to show labels in graph
	 * @param seriesType Map defining for each statistic type which seriesType shall be used
	 * @param filename filename to save the chart under
	 */
	public void generateChartWithAxes(String xAxisLabel, Boolean threeD, Boolean transposed,
			Map<StatisticType, Boolean> showStatistic,
			Map<StatisticType, Boolean> stacked, Map<StatisticType, Boolean> logarithmic,
			Map<StatisticType, Boolean> percentage, Map<StatisticType, Boolean> showLabels,
			Map<StatisticType, SeriesWithAxesType> seriesType, String filename) {
		
		String yaxisSize = "Number of Elements";
		String yaxisTime = "TimeConsumption(ms)";
		String yaxisCount = "Iterations Counted";
		
		HashMap<String, Boolean> stackedAxes = new HashMap<String, Boolean>();
		for(StatisticType st : stacked.keySet()){
			if(st == StatisticType.Count)
				stackedAxes.put(yaxisCount, stacked.get(st));
			if(st == StatisticType.Time)
				stackedAxes.put(yaxisTime, stacked.get(st));
			if(st == StatisticType.Size)
				stackedAxes.put(yaxisSize, stacked.get(st));			
		}
		HashMap<String, Boolean> logarithmicAxes = new HashMap<String, Boolean>();
		for(StatisticType st : logarithmic.keySet()){
			if(st == StatisticType.Count)
				logarithmicAxes.put(yaxisCount, logarithmic.get(st));
			if(st == StatisticType.Time)
				logarithmicAxes.put(yaxisTime, logarithmic.get(st));
			if(st == StatisticType.Size)
				logarithmicAxes.put(yaxisSize, logarithmic.get(st));			
		}
		HashMap<String, Boolean> percentageAxes = new HashMap<String, Boolean>();
		for(StatisticType st : percentage.keySet()){
			if(st == StatisticType.Count){
				percentageAxes.put(yaxisCount, percentage.get(st));
				if(percentage.get(st))
					yaxisCount+="(%)";
			}
			if(st == StatisticType.Time){
				percentageAxes.put(yaxisTime, percentage.get(st));
				if(percentage.get(st))
					yaxisTime.replace("ms", "%");
			}
			if(st == StatisticType.Size){
				percentageAxes.put(yaxisSize, percentage.get(st));
				if(percentage.get(st))
					yaxisSize+="(%)";
			}
		}
		HashMap<String, Boolean> showSeriesLabel = new HashMap<String, Boolean>();
		HashMap<String, SeriesWithAxesType> seriesTypes = new HashMap<String, SeriesWithAxesType>();

		for(StatisticType st : showLabels.keySet()){
			if(st == StatisticType.Count){
				for(String runs : experimentRuns.keySet()){
					for(String series : experimentRuns.get(runs).getCountStatistic().keySet()){
						showSeriesLabel.put(series, showLabels.get(st));
						seriesTypes.put(series, seriesType.get(st));
					}
				}
			}
			if(st == StatisticType.Time){
				for(String runs : experimentRuns.keySet()){
					for(String series : experimentRuns.get(runs).getTimeStatistic().keySet()){
						showSeriesLabel.put(series, showLabels.get(st));
						seriesTypes.put(series, seriesType.get(st));
					}
				}
			}
			if(st == StatisticType.Size){
				for(String runs : experimentRuns.keySet()){
					for(String series : experimentRuns.get(runs).getSizeStatistic().keySet()){
						showSeriesLabel.put(series, showLabels.get(st));
						seriesTypes.put(series, seriesType.get(st));
					}
				}
			}
		}
		
		HashMap<String, Map<String, Number[]>> axisTovalueMap = new HashMap<String, Map<String,Number[]>>();
		HashMap<String, Number[]> sizeValueMap = new HashMap<String, Number[]>();
		HashMap<String, Number[]> timeValueMap = new HashMap<String, Number[]>();
		HashMap<String, Number[]> countValueMap = new HashMap<String, Number[]>();

		// Sort exp Runs
		ArrayList<String> expRuns = new ArrayList<String>(experimentRuns.keySet());
		Collections.sort(expRuns);
		
		//All experiment runs need to have values for all series
		for (String countSer : experimentRuns.get(expRuns.get(0)).getCountStatistic().keySet()) {
			Number[] countValues = new Number[experimentRuns.size()];
			int i = 0;
			for(String run : expRuns){
				countValues[i] = (Number) experimentRuns.get(run).getCountStatistic().get(countSer);
				i++;
			}
			countValueMap.put(countSer, countValues);
		}
		for (String timeSer : experimentRuns.get(expRuns.get(0)).getTimeStatistic().keySet()) {
			Number[] timeValues = new Number[experimentRuns.size()];
			int i = 0;
			for(String run : expRuns){
				timeValues[i] = (Number) experimentRuns.get(run).getTimeStatistic().get(timeSer);
				i++;

			}
			timeValueMap.put(timeSer, timeValues);
		}
		for (String sizeSer : experimentRuns.get(expRuns.get(0)).getSizeStatistic().keySet()) {
			Number[] sizeValues = new Number[experimentRuns.size()];
			int i = 0;
			for(String run : expRuns){
				sizeValues[i] = (Number) experimentRuns.get(run).getSizeStatistic().get(sizeSer);
				i++;

			}
			sizeValueMap.put(sizeSer, sizeValues);
		}
		
		if(showStatistic.get(StatisticType.Count) && countValueMap.size() > 0)
			axisTovalueMap.put(yaxisCount, countValueMap);
		if(showStatistic.get(StatisticType.Time) && timeValueMap.size() > 0)
			axisTovalueMap.put(yaxisTime, timeValueMap);
		if(showStatistic.get(StatisticType.Size) && sizeValueMap.size() > 0)
			axisTovalueMap.put(yaxisSize, sizeValueMap);
		
		ChartsUtil.getInstance().writeChartWithAxes(experimentName, 
				xAxisLabel, threeD, transposed, stackedAxes, logarithmicAxes, percentageAxes, 
				showSeriesLabel, expRuns, seriesTypes, axisTovalueMap, filename);

	}
	/**
	 * Generates a chart without axes.
	 * 
	 * @param experimentRun Name of experiment run to use for chart
	 * @param st StatisticType to use for the chart
	 * @param threeD whether to render the chart in 3D or 2D
	 * @param showLabels whether to show labels in the chart
	 * @param seriesType defines which series type to use
	 * @param filename filename to save the chart under
	 */
	public void generateChartWithoutAxes(String experimentRun, StatisticType st,
			Boolean threeD, Boolean showLabels,
			SeriesWithoutAxesType seriesType,
			String filename) {
		
		String measurementTitle = null;
		Map<String, Number> valueMap = new HashMap<String, Number>();
		
		if(st == StatisticType.Count){
			measurementTitle = "Counted Iterations";
			for (String series : experimentRuns.get(experimentRun)
					.getCountStatistic().keySet()) {
				valueMap.put(series, (Number) experimentRuns
						.get(experimentRun).getCountStatistic().get(series));
			}			
		}
		if(st == StatisticType.Size) {
			measurementTitle = "Number of Elements";
			for (String series : experimentRuns.get(experimentRun)
					.getSizeStatistic().keySet()) {
				valueMap.put(series, (Number) experimentRuns
						.get(experimentRun).getSizeStatistic().get(series));
			}	
		}
		if(st == StatisticType.Time){
			measurementTitle = "TimeConsumption(ms)";
			for (String series : experimentRuns.get(experimentRun)
					.getTimeStatistic().keySet()) {
				valueMap.put(series, (Number) experimentRuns
						.get(experimentRun).getTimeStatistic().get(series));
			}	
		}
		
		ChartsUtil.getInstance().writeChartWithoutAxes(experimentName + "\n" + experimentRun, 
				measurementTitle, threeD, showLabels, seriesType, valueMap, filename);
		
	}
	
	/**
	 * Method for saving current experiment, including
	 * - name
	 * - experiment runs (with all statistics included)
	 * 
	 * @param folderPath path to save the experiment under
	 * @throws IOException
	 */
	public void saveExperiment(String folderPath) throws IOException{
		String filename = folderPath + "/" + this.experimentName + "_" + this.date + ".ser";
		FileOutputStream fileOut = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(this);
		out.close();
		fileOut.close();		
	}
	
	/**
	 * Method for loading an experiment.
	 * 
	 * @param filename file to load as experiment
	 * @return instantiated experiment loaded
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static ExperimentalUtil loadExperiment(String filename) throws IOException, ClassNotFoundException{
		FileInputStream fileIn = new FileInputStream(filename);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		ExperimentalUtil expUtil = (ExperimentalUtil) in.readObject();
		in.close();
		fileIn.close();		
		instance = expUtil;
		return instance;
			
	}
	
	/**
	 * Dumps the current experiment with its statistics
	 * @return string dumped
	 */
	public String dump(){
		
		String string = new String("*********************" + this.experimentName + " Statistics" + "*********************" + LINE_SEPERATOR+ LINE_SEPERATOR);
		for(String expRun : experimentRuns.keySet()){
			string += "---------- " + expRun + " ----------" + LINE_SEPERATOR;
			string += experimentRuns.get(expRun).dump();
			string += LINE_SEPERATOR;
		}
		string += LINE_SEPERATOR + LINE_SEPERATOR;
		string += "******************************************";	
		
		return string;
	}
	
}
