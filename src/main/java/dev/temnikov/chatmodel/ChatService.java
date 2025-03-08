package dev.temnikov.chatmodel;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.DefaultChatOptions;
import org.springframework.ai.chat.prompt.DefaultChatOptionsBuilder;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private ChatModel chatModel;

    public String getResponse(String promptText) {
        Prompt prompt = new Prompt(promptText);
        ChatResponse call = chatModel.call(prompt);
        return call.getResult().getOutput().getContent();
    }

    public String getResponseFromCustomOptions(String promptText) {
        ChatOptions chatOptions = new DefaultChatOptionsBuilder()
                .model("amazon.titan-text-express-v1")
                .topK(10)
                .temperature(0.1)
                .build();


       return ChatClient.create(this.chatModel)
                .prompt(promptText)
                .options(chatOptions)
                .call()
                .content();
    }
}