package com.example.chatApp.controller;

import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.chatApp.model.ChatMessage;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage") // /app/chat.sendMessage に送信されたら実行
    @SendTo("/topic/public")             // 全員に配信
    public ChatMessage sendMessage(ChatMessage message) {
    	
        if (message.getType() == ChatMessage.MessageType.REACTION) {
            // リアクションの特別処理
            System.out.println("Reaction received: " 
                + message.getSender() + " reacted with " 
                + message.getReaction() 
                + " to message " + message.getTargetMessageId());

            // 必要ならDBに記録したり集計も可能
            // 今回は受け取ったまま返して全員に配信
            return message;
            
        }
        
        //現在時刻をセット
        message.setTime(LocalDateTime.now());
        
        // ふつうのチャット・JOIN・LEAVEはそのまま返す
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(ChatMessage message) {
        message.setType(ChatMessage.MessageType.JOIN);
        return message;
    }
}
