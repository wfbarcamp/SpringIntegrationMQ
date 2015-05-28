package am.workfront.producer;

import am.workfront.event.*;
import am.workfront.producer.gateway.*;
import org.apache.log4j.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

/**
 * Created by Garik on 2/13/15.
 */
public class AppProducer {

	private MessageGateway gateway;

	public AppProducer() {
		init();
	}

	public static void main(String[] args) {

		try {
			AppProducer app = new AppProducer();

			app.sendChat();
			Thread.sleep(100);

			app.sendEmail();
			Thread.sleep(100);

			app.sendSMS();
			Thread.sleep(100);

			app.sendAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void init() {

		// initializes log4j
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.xml"));
		// initializes application
		ApplicationContext context = new ClassPathXmlApplicationContext("producer-context.xml");

		// retrieves message gateway
		gateway = (MessageGateway) context.getBean("messageGateway");
	}

	public void sendChat() {

		MessageEvent message = new MessageEvent.Builder()
			.setId(System.currentTimeMillis())
			.setType(MessageEvent.MessageType.CHAT)
			.setContent("some chat content")
			.build();

		gateway.process(message);
	}

	public void sendSMS() {

		MessageEvent message = new MessageEvent.Builder()
			.setId(System.currentTimeMillis())
			.setType(MessageEvent.MessageType.SMS)
			.setContent("some sms content")
			.build();

		gateway.process(message);
	}

	public void sendEmail() {

		MessageEvent message = new MessageEvent.Builder()
			.setId(System.currentTimeMillis())
			.setType(MessageEvent.MessageType.EMAIL)
			.setContent("some sms content")
			.build();

		gateway.process(message);
	}

	public void sendAll() {

		MessageEvent message = new MessageEvent.Builder()
			.setId(System.currentTimeMillis())
			.setType(MessageEvent.MessageType.ALL)
			.setContent("some all content")
			.build();

		gateway.process(message);
	}
}
