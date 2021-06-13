package com.marvel.tail.application.command;

import com.marvel.tail.application.adapter.TextAdapter;
import com.marvel.tail.application.dto.InsertTextDto;
import com.marvel.tail.domain.Text;
import com.marvel.tail.infrastructure.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertTextCommand {

    private BookService bookService;

    @Autowired
    public InsertTextCommand(BookService bookService) {
        this.bookService = bookService;
    }

    public Text handle(InsertTextDto insertTextDto) {

        var textDto = new TextAdapter();

        var text = textDto.adapt(insertTextDto);

        return bookService.addText(text);

    }
}
