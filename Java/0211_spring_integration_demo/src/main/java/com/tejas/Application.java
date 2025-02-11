package com.tejas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class Application implements ApplicationRunner{
	
	@Autowired
	private DirectChannel channel;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Message<String> message = MessageBuilder.withPayload("Hello Spring Integration World!!!").setHeader("key", "Metadata").build();
		channel.subscribe(
				new MessageHandler() {

					@SuppressWarnings("unchecked")
					@Override
					public void handleMessage(Message<?> message) throws MessagingException {
						System.out.println("Inside handleMessage() of MessageHandler : Message passing to handler !!!");
						new PrintService().print((Message<String>)message);
						
					}
				}
				);
		
		channel.send(message);
	}

}
