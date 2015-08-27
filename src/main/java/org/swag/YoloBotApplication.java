package org.swag;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YoloBotApplication {

	public static String server;
	public static String username;
	public static String password;
	public static int serverId;

	public static void main(String[] args) {
		if (args.length <= 3) {
			System.out.println("Pls provide username, server and password!");
			System.out
					.println("Usage: java -jar <fileName> <serverip> <username> <password> <virtualServerNr default 1>");
			return;
		}
		server = args[0];
		username = args[1];
		password = args[2];
		if (args.length == 4) {
			serverId = Integer.parseInt(args[3]);
		} else {
			System.out.println("No Server Id given setting serverid=1");
			serverId = 1;
		}
		SpringApplication.run(YoloBotApplication.class, args);
	}
}
