package am.workfront.consumer.endpoint.enricher;

import am.workfront.event.*;
import org.springframework.integration.annotation.*;

/**
 * Created by Garik on 2/14/15.
 */
@MessageEndpoint
public class MessageEventEnricher extends EventEnricher<MessageEvent> {


	@Override
	@Transformer
	public NotificationEvent<MessageEvent> transform(MessageEvent event) {
		System.out.println(event);
		return new NotificationEvent<MessageEvent>(event);
	}
}
