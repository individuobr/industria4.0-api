package br.edu.unicid.api.controller;


import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Controller
//@EnableScheduling
public class SocketController {
	
	private static final String SENDING_URL = "/topic/server-broadcaster";
    private static final String RECEIVING_URL = "/server-receiver";

    private final SimpMessagingTemplate template;
    private AtomicLong counter = new AtomicLong(0);

    private String message = "";

    @Autowired
    public SocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping(RECEIVING_URL)
    public void onReceivedMessage(String message) {
        System.out.println("New message received : " + message);
    }

    @SubscribeMapping(SENDING_URL)
    public String onSubscribe() {
        return "SUBSCRIBED : " + message;
    }

    @Scheduled(fixedRate = 1000)
    public void sendMessage(String msg) {
        template.convertAndSend(SENDING_URL, buildNextMessage(msg));
    }

    private String buildNextMessage(String msg) {
        message = msg + counter.getAndIncrement();
        System.out.println("Send message " + message);
        return message;
    }

}
