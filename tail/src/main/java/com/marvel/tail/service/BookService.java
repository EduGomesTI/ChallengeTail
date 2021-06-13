package com.marvel.tail.service;

import com.marvel.tail.domain.Text;
import com.marvel.tail.domain.Word;
import com.marvel.tail.repository.TextRepository;
import com.marvel.tail.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    private TextRepository textRepository;
    private WordRepository wordRepository;

    @Autowired
    public BookService(TextRepository textRepository, WordRepository wordRepository) {
        this.textRepository = textRepository;
        this.wordRepository = wordRepository;
    }

    @Transactional
    public Text addText(String text, List<Word> words){

        Text _text = new Text();
        _text.setText(text);
        _text.setWords(words);

        return textRepository.save(_text);
    }

    @Transactional
    public Iterable<Word> showWorlds()
    {
        return wordRepository.findAll();
    }
}
