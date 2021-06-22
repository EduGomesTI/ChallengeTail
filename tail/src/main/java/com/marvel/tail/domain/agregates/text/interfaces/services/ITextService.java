package com.marvel.tail.domain.agregates.text.interfaces.services;

import com.marvel.tail.domain.agregates.text.entities.Text;

import java.util.List;

public interface ITextService {

    List<String> splitTextInSentence(Text text);

    List<String> splitTextInWords(String sentence);

    String cleanText(String sentence);

}
