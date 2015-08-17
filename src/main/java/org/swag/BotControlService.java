package org.swag;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BotControlService {
	
	@Inject
	public YoloBot bot;
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public @ResponseBody String startBot(){
		bot.setServer("62.108.44.217");
		bot.setCredentals("yolo", "XbMXWRud");
		bot.start();
		return "Bot started!";
	}
	
	@RequestMapping(value = "/setMessage", method = RequestMethod.GET)
	public @ResponseBody String setMessage(@RequestParam("message") String message){
		bot.setMessage(message);
		bot.stop();
		bot.start();
		return "New message set!";
	}
	
	@RequestMapping(value = "/stop", method = RequestMethod.GET)
	public @ResponseBody String stopBot(){
		bot.stop();
		return "Bot stopped!";
	}

}