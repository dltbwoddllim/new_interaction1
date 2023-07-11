package com.example.chat.data.DTO;

public class MessageDTO {
    private String from;
    private String to;

    private String text;

    public MessageDTO() {
    }

    public MessageDTO(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

}