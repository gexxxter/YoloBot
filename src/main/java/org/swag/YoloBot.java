package org.swag;

import java.util.logging.Level;

import javax.inject.Named;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.TS3Query.FloodRate;
import com.github.theholywaffle.teamspeak3.api.event.ChannelCreateEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDeletedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDescriptionEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelPasswordChangedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientLeaveEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ServerEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.TS3Listener;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;

@Named
public class YoloBot implements TS3Listener {
	private String message = "Derb Derb SlaxXx rockt";
	public static String nickName = "yoloBot";
	public static int LOWEST_SERVER_GROUP = 8;

	private TS3Api api;
	private TS3Config config;
	private TS3Query query;

	public YoloBot() {
		config = new TS3Config();
		config.setDebugLevel(Level.ALL);
		config.setFloodRate(FloodRate.DEFAULT);
		
	}

	public void setServer(String server) {
		config.setHost(server);
	}

	public void setCredentals(String username, String password) {
		config.setLoginCredentials(username, password);
	}

	@Override
	public void onChannelCreate(ChannelCreateEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void start() {
		query = new TS3Query(config);
		query.connect();
		api = query.getApi();
		api.selectVirtualServerById(1);

		api.setNickname(nickName);
		api.sendChannelMessage(nickName + " is online!");
		api.registerAllEvents();
		api.moveClient(1);
		api.addTS3Listeners(this);
	}

	public void stop() {
		api.sendChannelMessage("YoloBot logging off...");
		api.unregisterAllEvents();
		api.logout();
		query.exit();
		api=null;
	}

	@Override
	public void onChannelDeleted(ChannelDeletedEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onChannelDescriptionChanged(ChannelDescriptionEditedEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onChannelEdit(ChannelEditedEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onChannelMoved(ChannelMovedEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onChannelPasswordChanged(ChannelPasswordChangedEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClientJoin(ClientJoinEvent arg0) {
		int clientServerGroup = Integer.parseInt(arg0.getClientServerGroups());
		if (clientServerGroup >= 8) {
			api.pokeClient(arg0.getClientId(), getMessage());
		}
	}

	@Override
	public void onClientLeave(ClientLeaveEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClientMoved(ClientMovedEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onServerEdit(ServerEditedEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextMessage(TextMessageEvent arg0) {
		// TODO Auto-generated method stub

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
