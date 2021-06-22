package com.marvel.tail.application.dto;

public class RequestText {
    private String text;

    public RequestText() {
    }

    public RequestText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
