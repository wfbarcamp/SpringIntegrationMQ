package am.workfront.event.header;

import am.workfront.event.*;

public class EventHeader {

	public String enrichHeader(ApplicationEvent event) {
		return event.getDestinationExpression();
	}
}

