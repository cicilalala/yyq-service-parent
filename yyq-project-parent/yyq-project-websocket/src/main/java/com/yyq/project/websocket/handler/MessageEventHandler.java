package com.yyq.project.websocket.handler;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.yyq.project.websocket.domain.Message;
import com.yyq.project.websocket.domain.Person;
import com.yyq.project.websocket.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class MessageEventHandler {

	@Autowired
	private SocketIOServer server;

	@Autowired
	private PersonRepository personRepository;

	/** 客户端发起连接 */
	@OnConnect
	public void onConnect(SocketIOClient client) {
		Long userId = Long.parseLong(client.getHandshakeData().getSingleUrlParam("userId"));

		Person person = personRepository.getById(userId);

		if (person != null) {
			log.info(person.getName() + "加入了链接！");

			person.setConnected(true);
			person.setSessionId(client.getSessionId().toString());
			personRepository.save(person);
		}
	}

	/** 客户端断开连接 */
	@OnDisconnect
	public void onDisconnect(SocketIOClient client) {
		Long userId = Long.parseLong(client.getHandshakeData().getSingleUrlParam("userId"));

		Person person = personRepository.getById(userId);

		if (person != null) {
			log.info(person.getName() + "断开了了链接！");
			person.setConnected(false);
			person.setSessionId(null);
			personRepository.save(person);
		}
	}

	/** 接收到消息后 */
	@OnEvent(value = "messageEvent")
	public void onEvent(SocketIOClient client, AckRequest request, Message message) {

		Long to = message.getTo();
		Person person = personRepository.getById(to);

		log.info("[" + message.getFrom() + "向" + message.getTo() + "]，发送了消息：" + message.getContent());

		if (person != null && person.isConnected()) {
			UUID uuid =  UUID.fromString(person.getSessionId());
			Message sendData = new Message();
			sendData.setTo(message.getTo());
			sendData.setFrom(message.getFrom());
			sendData.setContent(message.getContent());
			client.sendEvent("messageEvent", sendData);
			server.getClient(uuid).sendEvent("messageEvent", sendData);
		}
	}
}
