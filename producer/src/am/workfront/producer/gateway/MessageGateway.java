package am.workfront.producer.gateway;

import am.workfront.event.*;
import org.springframework.integration.annotation.*;

/**
 * Created by Garik on 2/13/15.
 */
public interface MessageGateway {

	@Gateway(requestChannel="eventChannel")
	public void process(Event event);
}
