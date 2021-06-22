package com.marvel.tail.api;

import com.marvel.tail.application.command.InsertTextCommand;
import com.marvel.tail.application.dto.RequestText;
import com.marvel.tail.application.query.QueryText;
import com.marvel.tail.domain.agregates.text.entities.Text;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/texts")
public class TextController {

    private QueryText queryText;
    private InsertTextCommand textCommand;

    public TextController(QueryText queryText, InsertTextCommand textCommand) {
        this.queryText = queryText;
        this.textCommand = textCommand;
    }

    @GetMapping
    public ResponseEntity<Iterable<Text>> list(){
        var texts = queryText.handle();
        return ResponseEntity.ok(texts);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Text> text(@PathVariable("id") long id){

        var text = queryText.handle(id);

        if(text.isPresent()){
            return ResponseEntity.ok(text.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody RequestText request) throws URISyntaxException {

        Text text = textCommand.handle(request);

        return ResponseEntity.created(
                new URI("/texts/" + text.getId())
        ).build();
    }
}
