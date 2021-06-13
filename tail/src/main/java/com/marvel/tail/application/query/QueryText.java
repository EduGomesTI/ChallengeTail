package com.marvel.tail.application.query;

import com.marvel.tail.application.query.Query;
import com.marvel.tail.domain.Text;
import com.marvel.tail.infrastructure.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueryText implements Query<Text> {

    private BookService bookService;

    @Autowired
    public QueryText(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Iterable<Text> handle() {
        var texts = bookService.listTexts();
        return texts;
    }

    @Override
    public Optional<Text> handle(long id) {
        return bookService.findById(id);
    }
}
