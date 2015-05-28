package am.workfront.consumer.endpoint.filter;

/**
 * Created by Garik on 2/14/15.
 */
public interface EventFilter<T> {

	public boolean validate(T event);
}
