package com.example.chatApp.model;

import java.time.LocalDateTime;

public class ChatMessage {
    private String id;
    private MessageType type;
    private String content;
    private String sender;
    private String image;
    private String reaction;
    private String targetMessageId;
    private LocalDateTime time;
    
    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE,
        REACTION
    }

    // getter / setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public MessageType getType() { return type; }
    public void setType(MessageType type) { this.type = type; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getReaction() { return reaction; }
    public void setReaction(String reaction) { this.reaction = reaction; }

    public String getTargetMessageId() { return targetMessageId; }
    public void setTargetMessageId(String targetMessageId) { this.targetMessageId = targetMessageId; }
    
    public LocalDateTime getTime(){ return time; }
    public void setTime(LocalDateTime time) { this.time = time; }
}
