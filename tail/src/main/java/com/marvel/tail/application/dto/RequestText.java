package com.marvel.tail.application.dto;

public class RequestText {
    private String text;
    private Integer qtdeTerms;

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

    public Integer getQtdeTerms() {
        return qtdeTerms;
    }

    public void setQtdeTerms(Integer qtdeTerms) {
        this.qtdeTerms = qtdeTerms;
    }
}
