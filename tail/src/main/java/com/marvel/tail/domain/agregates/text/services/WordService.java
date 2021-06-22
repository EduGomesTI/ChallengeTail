package com.marvel.tail.domain.agregates.text.services;

import com.marvel.tail.domain.agregates.text.interfaces.services.IWordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService implements IWordService {

    private double tf(List<String> sentences, String word) {

        double result = 0;
        for (String sentence : sentences) {
            if (word.equalsIgnoreCase(sentence))
                result++;
        }
        return result / sentences.size();
    }

    private double idf(List<List<String>> sentences, String term) {
        double n = 0;
        for (List<String> sentence : sentences) {
            for (String word : sentence) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        return Math.log(sentences.size() / n);
    }

    @Override
    public double tfIdf(List<String> sentence, List<List<String>> sentences, String word) {
        return tf(sentence, word) * idf(sentences, word);
    }
}
