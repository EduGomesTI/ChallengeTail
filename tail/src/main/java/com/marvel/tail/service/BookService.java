package com.marvel.tail.service;

import com.marvel.tail.domain.Text;
import com.marvel.tail.domain.Word;
import com.marvel.tail.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    private TextRepository textRepository;

    @Autowired
    public BookService(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    @Transactional
    public Text add(String text, List<Word> words){

        Text _text = new Text();
        _text.setText(text);
        _text.setWords(words);

        return textRepository.save(_text);
    }
}
