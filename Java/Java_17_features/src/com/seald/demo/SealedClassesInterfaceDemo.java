package com.seald.demo;

import com.seald.demo.events.AppEvent;
import com.seald.demo.events.DataUpdated;
import com.seald.demo.events.SystemShutdown;
import com.seald.demo.events.UserLoggedIn;

public class SealedClassesInterfaceDemo {
	public static void main(String[] args) {
		AppEvent e1 = new UserLoggedIn("tshinde");
		AppEvent e2 = new DataUpdated("Profiles List");
		AppEvent e3 = new UserLoggedIn("Shutting Down System");
		eventHandler(e1);
		eventHandler(e2);
		eventHandler(e3);
	}

	public static void eventHandler(AppEvent event) {
		switch (event) {
		// this is java 17 way to handle switch case : earlier only primitive types
		// ,enum and String used for case not object type can be
		// uses pattern matching here
		case UserLoggedIn login -> System.out.println("User Logged In : " + login.getUserId());
		case DataUpdated update -> System.out.println("Data updated for : " + update.getEntity());
		case SystemShutdown shutdown -> System.out.println("System shutdown");
		}

	}
}
