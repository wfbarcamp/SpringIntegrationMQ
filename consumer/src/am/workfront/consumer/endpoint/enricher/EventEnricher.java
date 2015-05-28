package am.workfront.consumer.endpoint.enricher;

import am.workfront.event.*;

/**
 * Created by Garik on 2/14/15.
 */
public abstract class EventEnricher<T extends ApplicationEvent> {

	public abstract NotificationEvent<T> transform(T t);
}
