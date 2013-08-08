package me.xir.radio.radiobot.utils;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import me.xir.radio.radiobot.RadioBot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.pircbotx.hooks.ListenerAdapter;

@SuppressWarnings("rawtypes")
public class Radio_Query extends ListenerAdapter {
	
	public static void repeatQuery() throws Exception {
		int delay = 5000; // delay for 5 sec.
		int period = 1000; // repeat every 1 sec.
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				RadioBot.bot.sendMessage("#radio","Current DJ: NULL"); 
			}
		}, delay, period);
	}
	
	public static void grabStreamInfo(String url) throws IOException {
		final String link = "";
		Document doc = Jsoup.connect(link).get();
		
		for( Element item : doc.select("item") ) // Select all items
		{
			
		}
		
		
	}

}
