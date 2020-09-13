package dev.drugowick.websocketdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class FloodClients {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedRate = 5000L)
    public void greeting() throws Exception {
        Random random = new Random();

        if (random.nextBoolean())
            simpMessagingTemplate.convertAndSend("/topic/greetings", new Greeting("System says: Whatever, dude!"));
    }
}
