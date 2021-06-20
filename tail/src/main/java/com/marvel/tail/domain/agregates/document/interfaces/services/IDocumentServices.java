package com.marvel.tail.domain.agregates.document.interfaces.services;

import com.marvel.tail.domain.agregates.document.entities.DocumentProperties;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public interface IDocumentServices {

    HashMap<String, Integer> getTermsFromFile(String Filename, int count, File folder);

    String cleanseInput(String input);

    boolean isDigit(String input);

    HashMap<String, Double> calculateInverseDocFrequency(DocumentProperties[] documentProperties);

    HashMap<String, Double> calculateTermFrequency(HashMap<String, Integer> input);

    void outputAsCSV(HashMap<String, Double> documents, String OutputPath) throws IOException;







}
