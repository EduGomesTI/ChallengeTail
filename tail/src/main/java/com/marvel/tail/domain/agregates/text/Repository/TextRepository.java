package com.marvel.tail.domain.agregates.text.Repository;

import com.marvel.tail.domain.agregates.text.entities.Text;
import com.marvel.tail.domain.agregates.text.entities.Word;
import com.marvel.tail.domain.agregates.text.interfaces.Repository.ITextRepository;
import com.marvel.tail.domain.agregates.text.interfaces.Repository.IWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TextRepository {

    private ITextRepository ITextRepository;
    private IWordRepository IWordRepository;

    @Autowired
    public TextRepository(ITextRepository ITextRepository, IWordRepository IWordRepository) {
        this.ITextRepository = ITextRepository;
        this.IWordRepository = IWordRepository;
    }

    @Transactional
    public Text addText(Text text){

        return ITextRepository.save(text);
    }

    @Transactional
    public Iterable<Text> listTexts(){
        return ITextRepository.findAll();
    }

    @Transactional
    public Optional<Text> findById(long textId){
        return ITextRepository.findById(textId);
    }

    @Transactional
    public Iterable<Word> showWorlds()
    {
        return IWordRepository.findAll();
    }
}
