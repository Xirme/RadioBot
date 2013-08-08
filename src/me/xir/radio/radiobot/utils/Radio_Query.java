package me.xir.radio.radiobot.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.xir.radio.radiobot.Config;
import me.xir.radio.radiobot.RadioBot;

import org.apache.commons.codec.binary.Base64;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.pircbotx.hooks.ListenerAdapter;

@SuppressWarnings("rawtypes")
public class Radio_Query extends ListenerAdapter {
	
	public static void grabStreamInfo() throws IOException {
		/* FUCK JSOUP FOR NOW AND TRY JDOM
		 * 
		 *  final String link = "http://" + Config.scserver + ":" + Config.scport + "/admin.cgi?mode=viewxml";
		
		String username = Config.scauser;
		String password = Config.scapass;
		String login = username + ":" + password;
		String base64login = new String(Base64.encodeBase64(login.getBytes()));

		Document doc = Jsoup.connect(link).userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.110 Safari/537.36").header("Authorization", "Basic " + base64login).timeout(10*1000).get();
		
		
		// start grabbing the XML fields here.
		  for (Element currentsong : doc.select("SONGTITLE")) {
			  RadioBot.bot.sendMessage("#radio","Current Song: " + currentsong); 
		    }
	}
*/
		SAXBuilder builder = new SAXBuilder();
		  File xmlFile = new File("http://dev.cyberpew.me/stats.xml");
	 
		  try {
	 
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List list = rootNode.getChildren("SHOUTCASTSERVER");
	 
			for (int i = 0; i < list.size(); i++) {
	 
			   Element node = (Element) list.get(i);
	 
			   RadioBot.bot.sendMessage("#radio","Current Song: " + node.getChildText("SONGTITLE"));
			}
	 
		  } catch (IOException io) {
			System.out.println(io.getMessage());
		  } catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		  }
		}
		
	
	public static void repeatQuery() throws Exception {
		int delay = 15000; // delay for 15 sec.
		int period = 10000; // repeat every 10 sec.
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				try {
					grabStreamInfo();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, delay, period);
	}
}
