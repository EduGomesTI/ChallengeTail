package com.marvel.tail.application.adapter;

import com.marvel.tail.application.dto.RequestText;
import com.marvel.tail.domain.agregates.text.entities.Text;

public class TextAdapter {

    public Text adapt(RequestText textDto){

        var text = new Text();
        text.setText(textDto.getText());
        text.setQtdeTerms(textDto.getQtdeTerms());

        return text;
    }
}
