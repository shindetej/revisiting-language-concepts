package com.seald.demo.events;

public final class UserLoggedIn implements AppEvent {
	private final String userId;

	public UserLoggedIn(String userId)
	{
		this.userId=userId;
	}

	public String getUserId() {
		// TODO Auto-generated method stub
		return this.userId;
	}
}
