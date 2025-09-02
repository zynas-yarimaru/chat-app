package com.example.chatApp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.chatApp.model.ChatMessage;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage") // /app/chat.sendMessage に送信されたら実行
    @SendTo("/topic/public")             // 全員に配信
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(ChatMessage message) {
        message.setType(ChatMessage.MessageType.JOIN);
        return message;
    }
}
