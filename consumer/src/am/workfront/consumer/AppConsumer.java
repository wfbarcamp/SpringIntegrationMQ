package am.workfront.consumer;

import org.apache.log4j.*;
import org.springframework.context.support.*;

/**
 * Created by Garik on 2/14/15.
 */
public class AppConsumer {

	public static void main(String[] args) {
		AppConsumer.init();
	}

	private static void init() {
		// initializes log4j
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.xml"));
		// initializes application
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer-context.xml");
	}
}
