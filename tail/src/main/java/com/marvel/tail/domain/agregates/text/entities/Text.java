package com.marvel.tail.domain.agregates.text.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Text {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Lob
    private String text;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Word> words;

    public Text() {

    }

    public Text(String text, List<Word> words) {
        this.text = text;
        this.words = words;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "Text{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", words=" + words +
                '}';
    }
}
