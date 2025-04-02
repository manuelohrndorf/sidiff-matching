package org.sidiff.comparators.events;

import org.sidiff.event.IEvent;

public class MatchInformationUsedEvent extends IEvent {

	private static final long serialVersionUID = 1L;

	public final static int USED_MATCH = createNewEvent();

	public final static int USED_ELEMENT_A_FEATURE = 0;
	public final static int USED_ELEMENT_B_FEATURE = 1;

	public MatchInformationUsedEvent(Object source, int eventID, Object... objects) {
		super(source, eventID, objects);
	}

}
