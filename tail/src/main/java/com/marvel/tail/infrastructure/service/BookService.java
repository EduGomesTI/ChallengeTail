package com.marvel.tail.infrastructure.service;

import com.marvel.tail.domain.Text;
import com.marvel.tail.domain.Word;
import com.marvel.tail.infrastructure.repository.TextRepository;
import com.marvel.tail.infrastructure.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    public Text addText(Text text){

        return textRepository.save(text);
    }

    @Transactional
    public Iterable<Text> listTexts(){
        return textRepository.findAll();
    }

    @Transactional
    public Optional<Text> findById(long textId){
        return textRepository.findById(textId);
    }

    @Transactional
    public Iterable<Word> showWorlds()
    {
        return wordRepository.findAll();
    }
}
