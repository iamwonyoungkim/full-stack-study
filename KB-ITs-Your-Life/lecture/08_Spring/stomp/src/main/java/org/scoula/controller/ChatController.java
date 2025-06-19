package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.domain.ChatMessage;
import org.scoula.domain.GreetingMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Log4j2
public class ChatController {
    /*
    @MessageMapping(메시지경로)
    - 클라이언트가 보낸 메시지의 경로와 일치하는 경우 해당 메서드 호출
    - 메시지의 Body를 매개변수의 객체로 변환하여 전달
    - setApplicationDestinationPrefixes()에서 지정한 prefix는 제외하고 지정

    @SendTo(토픽)
    - 해당 메서드의 리턴값을 지정한 토픽으로 전송
     */

    @MessageMapping("/hello") // prefix를 설정해뒀으므로 /app/hello 이다
    @SendTo("/topic/greetings") // 이 토픽 구독자에게 메시지 전송
    public GreetingMessage greeting(GreetingMessage message) throws Exception {
        log.info("greeting: " + message);
        return message;
    }

    @MessageMapping("/chat") // /app/chat
    @SendTo("/topic/chat")
    public ChatMessage chat(ChatMessage message) throws Exception {
        log.info("chat received: " + message);
        return message;
    }
}
