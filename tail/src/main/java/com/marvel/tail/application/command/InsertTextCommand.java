package com.marvel.tail.application.command;

import com.marvel.tail.application.adapter.TextAdapter;
import com.marvel.tail.application.dto.InsertTextDto;
import com.marvel.tail.domain.Text;
import com.marvel.tail.domain.Word;
import com.marvel.tail.infrastructure.repository.TfIdf;
import com.marvel.tail.infrastructure.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        //dividir o texto em 3 frases e colocar em um array ou List.
        //O primeiro doc será o texto completo.
        List<String> sentences = splitTextInSentence(text.getText());

        //dividir cada array de frases em um array de palavras

        //chama o TfIdf

       //List<String> words = splitSentecesInWords(text.getText());

        List<String> doc1 = Arrays.asList("Lorem", "ipsum", "dolor", "ipsum", "sit", "ipsum");
        List<String> doc2 = Arrays.asList("Vituperata", "incorrupte", "at", "ipsum", "pro", "quo");
        List<String> doc3 = Arrays.asList("Has", "persius", "disputationi", "id", "simul");
        List<List<String>> documents = Arrays.asList(doc1, doc2, doc3);

       //List<List<String>> docs = Arrays.asList(words);

        List<TfIdf> tfIdf = GetTfIdf(doc1, documents, "ipsum");

        System.out.println(tfIdf);

        return bookService.addText(text);

    }

    private List<String> splitTextInSentence(String text) {

        return  new ArrayList<>();

    }

    private List<String> splitSentecesInWords(String text) {

        var _text = text;

        String[] words = _text.split(" ");

        for (var i = 0;i<words.length;i++){
            words[i] = words[i].replace(",", "");
            words[i] = words[i].replace(".", "");
            words[i] = words[i].replace("!", "");
            words[i] = words[i].replace("?", "");
            words[i] = words[i].replace(";", "");
            words[i] = words[i].replace(":", "");
            words[i] = words[i].replace("/", "");
            words[i] = words[i].replace("\\", "");
            words[i] = words[i].replace("=", "");
            words[i] = words[i].replace("\"", "");
            words[i] = words[i].replace("\'", "");
        }

        return Arrays.asList(words);
    }

    private List<TfIdf> GetTfIdf(List<String> words, List<List<String>> docs, String term) {

        var tfIdfs = new ArrayList<TfIdf>();

        for(var word : words){
            Word _word = new Word();
            _word.setWord(word);

            DecimalFormat formatador = new DecimalFormat("0.00000");

            float frequency = tfIdf(words, docs, term);

            TfIdf tfIdf = new TfIdf();
            tfIdf.setWord(_word);
            tfIdf.setFrequency(formatador.format(frequency));

            tfIdfs.add(tfIdf);
        }

        return tfIdfs;

    }

    public float tf(List<String> doc, String term) {
        float result = 0;
        for (String word : doc) {
            if (term.equalsIgnoreCase(word))
                result++;
        }

        result = result / doc.size();

        return result;
    }

    public float idf(List<List<String>> docs, String term) {
        float n = 0;
        for (List<String> doc : docs) {
            for (String word : doc) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }

        var result = (float) Math.log(docs.size() / n);

        return result;
    }

    public float tfIdf(List<String> doc, List<List<String>> docs, String term) {
        return tf(doc, term) * idf(docs, term);

    }

}
