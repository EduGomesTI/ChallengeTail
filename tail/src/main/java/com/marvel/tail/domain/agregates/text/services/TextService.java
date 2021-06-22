package com.marvel.tail.domain.agregates.text.services;

import com.marvel.tail.domain.agregates.text.entities.Text;
import com.marvel.tail.domain.agregates.text.interfaces.services.ITextService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class TextService implements ITextService {

    @Override
    public List<String> splitTextInSentence(Text text) {

        var separator = "#@#";

        var newText = text.getText().replaceAll("[.!?:;]", separator);

        var sentences = newText.split(separator);

        for(var sentence : sentences){
            sentence = cleanText(sentence);
        }

        return Arrays.asList(sentences);
    }

    @Override
    public String cleanText(String sentence) {

        var newSentence = sentence;

        newSentence = newSentence.replaceAll("[\\p{P}\\p{S}]", "");

        return newSentence;

    }

    @Override
    public List<String> splitTextInWords(String sentence) {

        var words = sentence.split(" ");

        var _words = new ArrayList<String>();

        for(var i = 0; i < words.length; i++){
            if(words[i].length() > 2){
                _words.add(words[i]);
            }
        }

        var arrayWords = _words.toArray();

        //junta 2 palavras para formar termos compostos
        for(var i = 0; i < arrayWords.length - 1; i++){
            var termCompost = String.format("%s %s", arrayWords[i], arrayWords[i+1]);
            _words.add(termCompost);
        }

        return _words;
    }


}
