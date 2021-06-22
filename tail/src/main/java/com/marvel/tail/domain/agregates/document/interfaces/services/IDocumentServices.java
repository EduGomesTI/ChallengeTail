package com.marvel.tail.domain.agregates.document.interfaces.services;

import com.marvel.tail.domain.agregates.document.entities.Document;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public interface IDocumentServices {

    HashMap<String, Integer> getWordsFromDocuments(String Filename, int count, File folder);

    String cleanseInput(String input);

    boolean isDigit(String input);

    HashMap<String, Double> calculateIDF(Document[] documents);

    HashMap<String, Double> calculateTF(HashMap<String, Integer> input);

    void outputAsCSV(HashMap<String, Double> documents, String OutputPath) throws IOException;
}
