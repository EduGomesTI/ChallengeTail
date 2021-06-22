package com.marvel.tail.domain.agregates.text.interfaces.services;

import java.util.List;

public interface IWordService {

    double tfIdf(List<String> text, List<List<String>> sentences, String word);

}
