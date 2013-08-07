package me.xir.radio.radiobot.commands;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

@SuppressWarnings("rawtypes")
public class Basic_Information extends ListenerAdapter {
	public void onMessage(MessageEvent event) throws Exception {
		if (event.getMessage().startsWith("song")) {
			event.getBot().sendMessage(event.getChannel(), "Current song: NULL"); 
		}
		if (event.getMessage().startsWith("listen")) {
			event.getBot().sendMessage(event.getChannel(), "Listen here: NULL"); 
		}
		if (event.getMessage().startsWith("dj")) {
			event.getBot().sendMessage(event.getChannel(), "Current DJ: NULL"); 
		}
	}
}
