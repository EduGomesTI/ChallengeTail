package com.marvel.tail.application.adapter;

import com.marvel.tail.application.dto.InsertTextDto;
import com.marvel.tail.domain.agregates.text.entities.Text;

public class TextAdapter {

    public Text adapt(InsertTextDto textDto){

        var text = new Text();
        text.setText(textDto.getText());

        return text;
    }
}
