package am.workfront.consumer.router;

import am.workfront.event.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.integration.*;
import org.springframework.integration.annotation.*;
import org.springframework.integration.router.*;

/**
 * Created by Garik on 2/14/15.
 */
@MessageEndpoint
public class AllChannelsRouter {

	@Autowired
	private RecipientListRouter recipientListRouter;

	@ServiceActivator(inputChannel = "allChannels")
	public void route(Message<NotificationEvent<MessageEvent>> message) {
		recipientListRouter.handleMessage(message);
	}
}
