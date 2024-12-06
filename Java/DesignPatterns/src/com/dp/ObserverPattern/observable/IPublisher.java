package com.dp.ObserverPattern.observable;

import java.util.List;

import com.dp.ObserverPattern.observer.ISubscriber;

public interface IPublisher {
	void addSubscriber(ISubscriber subscriber);

	void removeSubscriber(ISubscriber subscriber);

	void notifySubscriber();

	void setData(int data);

	void getData();

	List<ISubscriber> getListOfSubscribers();

}
