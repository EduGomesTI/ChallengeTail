package com.marvel.tail.application.dto;

public class InsertTextDto {
    private String text;

    public InsertTextDto() {
    }

    public InsertTextDto(String text) {

        this.text = text;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {

        this.text = text;
    }


}
