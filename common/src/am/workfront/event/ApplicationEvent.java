package am.workfront.event;

import org.codehaus.jackson.annotate.*;

import java.io.*;

/**
 * Created by Garik on 2/14/15.
 */
public abstract class ApplicationEvent implements Event, Serializable {

	/*
	 *	The subclass must override this to provide the event name.
	 */
	@Override
	public abstract String getEventType();

	@JsonIgnore
	public String getDestinationExpression() {
		return "VirtualTopic." + getEventType();
	}

	@JsonIgnore
	public Serializable getPayloadSource() {
		return this;
	}
}
