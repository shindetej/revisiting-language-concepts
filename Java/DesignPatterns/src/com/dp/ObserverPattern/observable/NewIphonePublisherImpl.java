package com.dp.ObserverPattern.observable;

import java.util.ArrayList;
import java.util.List;

import com.dp.ObserverPattern.observer.ISubscriber;

public class NewIphonePublisherImpl implements IPublisher {

	List<ISubscriber> oberserverList = new ArrayList<>();
	public int iPhoneNewArrivalCount = 0;

	@Override
	public void addSubscriber(ISubscriber subscriber) {
		oberserverList.add(subscriber);
	}

	@Override
	public void removeSubscriber(ISubscriber subscriber) {
		oberserverList.remove(subscriber);
	}

	@Override
	public void notifySubscriber() {
		System.out.println("IN notifySubscriber() ");
		for (ISubscriber s : oberserverList) {
			s.update();
		}
	}

	@Override
	public void setData(int newStock) {
		System.out.println("In setData()");
		if (iPhoneNewArrivalCount == 0) {
			notifySubscriber();
		}

		iPhoneNewArrivalCount = iPhoneNewArrivalCount + newStock;
	}

	@Override
	public void getData() {
		System.out.println("In getData()");
	}

	@Override
	public List<ISubscriber> getListOfSubscribers() {
		return oberserverList;
	}

}
