package com.marvel.tail.domain.agregates.document.entities;

import java.util.HashMap;

public class Document {

     private HashMap<String,Double> word;
     private HashMap<String,Integer> frequency;

    public HashMap<String,Double> getWord()
    {
        return word;
    }

    public HashMap<String,Integer> getFrequency()
    {
        return frequency;
    }

    public void setWord(HashMap<String,Double> input)
    {
        word = new HashMap<String, Double>(input);
    }

    public void setFrequency(HashMap<String,Integer> input)
    {
        frequency =new HashMap<String, Integer>(input);
    }
}
