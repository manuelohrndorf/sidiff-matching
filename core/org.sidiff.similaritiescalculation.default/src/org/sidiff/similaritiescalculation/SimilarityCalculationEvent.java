package org.sidiff.similaritiescalculation;

import org.sidiff.event.IEvent;

/**
 * Event class to throw events if elements are compared.
 * 
 * @author wenzel
 *
 */
public class SimilarityCalculationEvent extends IEvent {

	private static final long serialVersionUID = 1L;

	public final static int START_COMPARISON = createNewEvent();
	public final static int STOP_COMPARISON = createNewEvent();
	public final static int START_COMPAREFUNCTION = createNewEvent();
	public final static int STOP_COMPAREFUNCTION = createNewEvent();

	public final static int COMPARISON_ELEMENT_A_FEATURE = 0;
	public final static int COMPARISON_ELEMENT_B_FEATURE = 1;
	public final static int COMPARISON_SIMILARITY_VALUE = 2;
	public final static int COMPAREFUNCTION_FEATURE = 0;
	public final static int RESULT_FEATURE = 0;

	public SimilarityCalculationEvent(Object source, int eventID, Object... objects) {
		super(source, eventID,objects);
	}

}
