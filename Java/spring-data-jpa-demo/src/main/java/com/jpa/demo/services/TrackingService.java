package com.jpa.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.demo.exceptions.InvalidOrderIdException;
import com.jpa.demo.models.Tracking;
import com.jpa.demo.repos.ITrackingRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TrackingService implements ITrackingService {

	@Autowired
	private ITrackingRepository trackingRepository;

	public Tracking saveTrackingInfo(Tracking tracking) {
		return trackingRepository.save(tracking);
	}

	@Override
	public Tracking updateTrackingInfo(Tracking tracking) {
		Optional<Tracking> existing = trackingRepository.findById(tracking.getTrackingId());
		Tracking existingObj =null;
		if (existing.isPresent()) {
			existingObj = existing.get();
			if (tracking.getShipmentNumber() != null)
				existingObj.setShipmentNumber(tracking.getShipmentNumber());
			if (tracking.getTrackingStatus() != null)
				existingObj.setTrackingStatus(tracking.getTrackingStatus());
			if (tracking.getTrackingStatus() != null)
				existingObj.setTrackingVendor(tracking.getTrackingVendor());
		}
		return trackingRepository.saveAndFlush(existingObj);
	}

	@Override
	public List<Tracking> getTrackingList() {
		return trackingRepository.findAll();
	}

	@Override
	public Tracking getTrackingById(Long id) {
		Tracking existing = trackingRepository.findById(id)
				.orElseThrow(() -> new InvalidOrderIdException("Order Not Found"));
		return existing;
	}

}
