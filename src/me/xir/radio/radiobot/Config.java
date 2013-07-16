package me.xir.radio.radiobot;

//Java imports
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {

	public static Properties config = new Properties();
	static String nick;
	static String user;
	static String server;
	static int port;
	static String pass;
	static String serverpass;
	static boolean SSL;
	static String[] channels;
	public static String[] admins;

	public static void loadConfig() throws FileNotFoundException, IOException {
		config.load(new FileInputStream("CyBot.properties"));
		nick = config.getProperty("nick");
		user = config.getProperty("user");
		server = config.getProperty("server");
		port = Integer.parseInt(config.getProperty("port"));
		SSL = Boolean.parseBoolean(config.getProperty("SSL"));
		pass = config.getProperty("pass");
		serverpass = config.getProperty("serverpass");
		channels = config.getProperty("channels").split(",");
		admins = config.getProperty("admins").split(",");
	}
}
