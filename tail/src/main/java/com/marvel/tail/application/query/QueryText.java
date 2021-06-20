package com.marvel.tail.application.query;

import com.marvel.tail.domain.agregates.text.entities.Text;
import com.marvel.tail.domain.agregates.text.Repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueryText implements Query<Text> {

    private TextRepository textRepository;

    @Autowired
    public QueryText(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    @Override
    public Iterable<Text> handle() {
        var texts = textRepository.listTexts();
        return texts;
    }

    @Override
    public Optional<Text> handle(long id) {
        return textRepository.findById(id);
    }
}
