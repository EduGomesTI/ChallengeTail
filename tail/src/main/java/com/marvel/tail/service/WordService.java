package com.marvel.tail.service;

import com.marvel.tail.domain.Word;
import com.marvel.tail.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class WordService {

    private WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Autowired


    @Transactional
    public Iterable<Word> showWorlds()
    {
        return wordRepository.findAll();
    }
}
