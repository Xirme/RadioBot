package me.xir.radio.radiobot.commands;

import java.io.File;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

@SuppressWarnings("rawtypes")
public class Basic_Information extends ListenerAdapter {

	public void onMessage(MessageEvent event) throws Exception {
		
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File("stats.xml");
		
		Document document = (Document) builder.build(xmlFile);
		Element rootNode = document.getRootElement();
		Element node = rootNode;
		
		
		
		if (event.getMessage().startsWith("song")) {
			event.getBot().sendMessage(event.getChannel(), "Current song: " + node.getChildText("SONGTITLE")); 
		}
		if (event.getMessage().startsWith("listen")) {
			event.getBot().sendMessage(event.getChannel(), "Listen here: NULL"); 
		}
		if (event.getMessage().startsWith("dj")) {
			event.getBot().sendMessage(event.getChannel(), "Current DJ: NULL"); 
		}
	}
}
