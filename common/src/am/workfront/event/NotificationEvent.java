package am.workfront.event;

import java.io.*;

/**
 * Created by Garik on 2/14/15.
 */
public class NotificationEvent<T> implements Serializable {

	private T event;

	public NotificationEvent(T event) {
		this.event = event;
	}

	public T getEvent() {
		return event;
	}
}
