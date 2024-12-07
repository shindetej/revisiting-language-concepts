package com.dp.Main;

import com.dp.ObserverPattern.observable.IPublisher;
import com.dp.ObserverPattern.observable.NewIphonePublisherImpl;
import com.dp.ObserverPattern.observer.EmailSubscriber;
import com.dp.ObserverPattern.observer.ISubscriber;
import com.dp.ObserverPattern.observer.WhatsappSubscriber;

public class ObserverPatternMain {
	
	public static void main(String[] args) {
		
		// create publisher(observable) instance
		IPublisher iphoneObservable=  new NewIphonePublisherImpl();
		
		// create subscriber(observer) instance
		ISubscriber emailSub =  new  EmailSubscriber("tshinde@ph.tech", iphoneObservable);
		ISubscriber emailSub1 =  new  EmailSubscriber("stitir@ph.tech", iphoneObservable);
		ISubscriber whatsappSub =  new  WhatsappSubscriber("7709943112", iphoneObservable);
		
		iphoneObservable.addSubscriber(emailSub);
		iphoneObservable.addSubscriber(emailSub1);
		iphoneObservable.addSubscriber(whatsappSub);
		
		iphoneObservable.setData(10);
		
	}

}
