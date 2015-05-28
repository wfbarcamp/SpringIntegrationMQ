package am.workfront.consumer.endpoint.filter;

import am.workfront.event.*;
import am.workfront.util.*;
import org.springframework.integration.annotation.*;

/**
 * Created by Garik on 2/14/15.
 */
@MessageEndpoint
public class MessageEventFilter implements EventFilter<MessageEvent> {

	@Override
	@Filter
	public boolean validate(MessageEvent event) {

		//System.out.println(event);
		if (event == null) {
			// TODO smth
			return false;
		}

		if (Validator.isEmpty(event.getContent())) {
			// TODO smth
			return false;
		}

		return true;
	}
}
