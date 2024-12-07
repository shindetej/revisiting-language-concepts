package com.dp.ObserverPattern.observer;

import com.dp.ObserverPattern.observable.IPublisher;

public class WhatsappSubscriber implements ISubscriber{
	private String mobileNo;
	private IPublisher publisher;
	
	public WhatsappSubscriber(String mobileNo, IPublisher pub) {
		this.mobileNo = mobileNo;
		this.publisher = publisher;
	}

	public void update() {
		System.out.println("In WhatsappSubscriber update()");
		whatsAppMessage(mobileNo,"New Apple Phone Arrived!!!");
	}
	
	private void whatsAppMessage(String emailId2, String string) {
		System.out.println("Message to : "+this.mobileNo);
	}

}
