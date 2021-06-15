package com.marvel.tail.infrastructure.repository;

import com.marvel.tail.domain.Word;

public class TfIdf {

    private Word word;
    private String frequency;

    public TfIdf() {
    }

    public TfIdf(Word word, String frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
