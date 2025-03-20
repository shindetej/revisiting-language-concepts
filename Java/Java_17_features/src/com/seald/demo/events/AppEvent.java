package com.seald.demo.events;

// event-driven systems, we often deal with a fixed set of event types. 
//Using sealed classes ensures that only specific event types exist, preventing unauthorized extension.
public sealed interface AppEvent permits UserLoggedIn,DataUpdated,SystemShutdown{

}
