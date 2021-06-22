package com.marvel.tail.application.command;

import com.marvel.tail.application.adapter.TextAdapter;
import com.marvel.tail.application.dto.RequestText;
import com.marvel.tail.domain.agregates.text.entities.Text;
import com.marvel.tail.domain.agregates.text.Repository.TextRepository;
import com.marvel.tail.domain.agregates.text.entities.Word;
import com.marvel.tail.domain.agregates.text.services.TextService;
import com.marvel.tail.domain.agregates.text.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InsertTextCommand {

    private TextRepository textRepository;
    private TextService textService;
    private WordService wordService;

    @Autowired
    public InsertTextCommand(TextRepository textRepository, TextService textService, WordService wordService) {
        this.textRepository = textRepository;
        this.textService = textService;
        this.wordService = wordService;
    }

    public Text handle(RequestText requestText) {

        List<List<String>> document = new ArrayList<>();

        var textDto = new TextAdapter();

        var text = textDto.adapt(requestText);

        //limpa o texto completo
        var textClean = textService.cleanText(text.getText());

        //pega todas as palavras do texto e retira as com 1 ou 2 letras
        var allWordsInText = textService.splitTextInWords(textClean);
        document.add(allWordsInText);

        //dividir o texto em frases e colocar em um array ou List.
        var sentences = textService.splitTextInSentence(text);

        //dividir cada array de frases em um array de palavras
        for(var sentence : sentences){
            document.add(textService.splitTextInWords(sentence));
        }

        //calcula o TfIDF de cada palavra do texto
        var wordList = new ArrayList<Word>();
        for(var term : allWordsInText){

            var frequency = wordService.tfIdf(allWordsInText, document, term);

            var word = new Word();
            word.setWord(term);
            word.setFrequency(frequency);
           wordList.add(word);
        }

        Map<String, Word> word1 = new HashMap<>();
        for(var i = 0; i<wordList.size();i++){
            var freq = wordList.get(i).getWord();
            var w = wordList.get(i);
            word1.put(freq, w);
        }

        List<Word> wordsByFrequency = new ArrayList(word1.values());

        Collections.sort(wordsByFrequency, Comparator.comparing(Word::getFrequency));

        Collections.reverse(wordsByFrequency);

        List<Word> newSortedWords = new ArrayList<>();

        var zero = 0;

        for(var i=zero;i<text.getQtdeTerms();i++){
            newSortedWords.add(wordsByFrequency.get(i));
        }

        text.setWords(newSortedWords);

          return textRepository.addText(text);

    }


}
