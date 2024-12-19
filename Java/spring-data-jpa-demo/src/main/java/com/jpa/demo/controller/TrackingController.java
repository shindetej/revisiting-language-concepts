package com.jpa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.demo.models.Tracking;
import com.jpa.demo.responses.Response;
import com.jpa.demo.services.ITrackingService;

@RestController
@RequestMapping("/tracking")
public class TrackingController {
	@Autowired
	private ITrackingService trackingService;

	@PostMapping
	public ResponseEntity<?> addTracking(@RequestBody Tracking tracking) {
		Tracking result = trackingService.saveTrackingInfo(tracking);

		return new ResponseEntity<>(new Response<>("Tracking Saved Succesfully", result, HttpStatus.CREATED.value()),
				HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> updateTracking(@RequestBody Tracking tracking) {
		Tracking result = trackingService.updateTrackingInfo(tracking);
		return new ResponseEntity<>(new Response<>("Tracking Updated Succesfully", result, HttpStatus.OK.value()),
				HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<?> getAllTrackingDetails() {
		return new ResponseEntity<>(new Response<>("Tracking Updated Succesfully", trackingService.getTrackingList(),
				HttpStatus.OK.value()), HttpStatus.OK);
	}
}
