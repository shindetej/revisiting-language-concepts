package com.jpa.demo.services;

import java.util.List;

import com.jpa.demo.models.Tracking;


public interface ITrackingService {
	Tracking saveTrackingInfo(Tracking tracking);
	Tracking updateTrackingInfo(Tracking tracking);
	List<Tracking> getTrackingList();
	Tracking getTrackingById(Long id);
}
