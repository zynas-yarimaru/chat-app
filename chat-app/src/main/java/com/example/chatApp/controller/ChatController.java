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
    
    @MessageMapping("/chat.deleteMessage")
    @SendTo("/topic/public")
    public ChatMessage deleteMessage(ChatMessage deleteMessage) {
    		System.out.println("controller");
        // 削除通知用のメッセージを生成
        ChatMessage deleteNotice = new ChatMessage();
        deleteNotice.setType(ChatMessage.MessageType.DELETE); // ← enumにDELETEを追加しておく
        deleteNotice.setTargetMessageId(deleteMessage.getTargetMessageId()); // どのメッセージを消すか
        
        return deleteNotice; // 全員に配信される
    }
    
}
