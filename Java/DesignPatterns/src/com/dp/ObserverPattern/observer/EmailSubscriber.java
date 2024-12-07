package com.dp.ObserverPattern.observer;

import com.dp.ObserverPattern.observable.IPublisher;

public class EmailSubscriber implements ISubscriber {
	private String emailId ;
	private IPublisher publisher;

	public EmailSubscriber(String email ,IPublisher publisher) {
		this.emailId = email;
		this.publisher = publisher;
	}
	
	@Override
	public void update() {
		System.out.println("In EmailSubscriber update()");
		sendEmail(this.emailId,"Iphone new stock arrived !");
	}

	private void sendEmail(String emailId2, String string) {
		System.out.println("Emailed to : "+this.emailId);
	}

}
