package com.tejas;

import java.util.Map.Entry;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class PrintService {
	public void print(Message<String> message)
	{
		MessageHeaders headers = message.getHeaders();
		System.out.println("HEADERS DETAILS");
		for(Entry<String, Object> entry : headers.entrySet()) {
			System.out.println(entry.getKey()+ " : "+entry.getValue());
		}
		
		System.out.println("Message payload :" + message.getPayload());
		
		
	}
}
