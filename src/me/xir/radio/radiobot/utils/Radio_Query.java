package me.xir.radio.radiobot.utils;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import me.xir.radio.radiobot.Config;
import me.xir.radio.radiobot.RadioBot;

import org.apache.commons.codec.binary.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.pircbotx.hooks.ListenerAdapter;

@SuppressWarnings("rawtypes")
public class Radio_Query extends ListenerAdapter {
	
	public static void grabStreamInfo(String url) throws IOException {
		final String link = "http://" + Config.scserver + Config.scport + "/admin.cgi?mode=viewxml";
		
		String username = Config.scauser;
		String password = Config.scapass;
		String login = username + ":" + password;
		String base64login = new String(Base64.encodeBase64(login.getBytes()));

		Document doc = Jsoup.connect(link).header("Authorization", "Basic " + base64login).get();
		
		// start grabbing the XML fields here.
		
	}

	
	public static void repeatQuery() throws Exception {
		int delay = 15000; // delay for 15 sec.
		int period = 10000; // repeat every 10 sec.
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				// do things
			}
		}, delay, period);
	}
}
