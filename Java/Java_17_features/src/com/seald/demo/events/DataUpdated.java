package com.seald.demo.events;

public final class DataUpdated implements AppEvent {
	private final String entity;

	public DataUpdated(String entity) {
		this.entity = entity;
	}

	public String getEntity() {
		// TODO Auto-generated method stub
		return this.entity;
	}
}
