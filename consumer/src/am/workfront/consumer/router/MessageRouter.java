package am.workfront.consumer.router;

import am.workfront.event.*;
import org.springframework.integration.annotation.*;

import am.workfront.event.MessageEvent.MessageType;

import java.util.*;

/**
 * Created by Garik on 2/14/15.
 */
//@MessageEndpoint
public class MessageRouter {

	@Router(inputChannel = "messageOutputChannel")
	public String route(NotificationEvent<MessageEvent> ne) {

		MessageType type = ne.getEvent().getType();
		switch (type) {
			case SMS:
				return "smsChannel";
			case EMAIL:
				return "emailChannel";
			case CHAT:
				return "chatChannel";
		}
		throw new RuntimeException("Message type is undefined [type: " + type + "]");
	}

	@Router(inputChannel = "allChannels")
	public List<String> routeAll(NotificationEvent<MessageEvent> ne) {
		return Arrays.asList(
			"smsChannel",
			"emailChannel",
			"chatChannel"
		);
	}


}
