package dev.temnikov.chatmodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    ChatService chatService;

    @GetMapping("/chat")
    public String getResponse(@RequestParam String prompt) {
        return chatService.getResponse(prompt);
    }
}
