package br.edu.unicid.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import br.edu.unicid.api.services.SocketService;

//@Configuration
//@EnableScheduling
public class WebSocketSchedulerConfig {

//	@Autowired
	private SimpMessagingTemplate template;

//	@Autowired
	private SocketService socketService;

//	@Scheduled(fixedRate = 3000)
	public void publishUpdates() {
		System.out.println("Message: " + socketService.getMessage().getMsg());
		template.convertAndSend("/topic/greeting", socketService.getMessage());
	}
}
