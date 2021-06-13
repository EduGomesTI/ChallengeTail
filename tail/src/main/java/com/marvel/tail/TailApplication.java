package com.marvel.tail;

import com.marvel.tail.domain.Text;
import com.marvel.tail.domain.Word;
import com.marvel.tail.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class TailApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(TailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ArrayList<Word> words = new ArrayList<>();
		words.add(new Word("Abacaxi"));
		words.add(new Word("laranja"));
		words.add(new Word("Uva"));

		String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lacinia ante vel ante " +
				"suscipit aliquam. Cras pulvinar ullamcorper condimentum. Nulla dapibus urna diam, ut malesuada " +
				"enim ultricies quis. Maecenas pulvinar, tellus sed facilisis finibus, mi augue accumsan massa, eu " +
				"dictum nunc libero nec nisi. Nulla nec feugiat nunc. Nullam quis orci laoreet, fringilla purus " +
				"aliquet, placerat purus. Nullam pellentesque diam nec efficitur pellentesque. Ut ut metus feugiat, " +
				"tincidunt magna ac, varius augue. Donec leo sapien, iaculis vitae erat id, luctus pretium libero. " +
				"Sed vestibulum mollis nulla ut euismod.";

		line();
		System.out.println("TailApplication.run");
		line();
		System.out.println("Criar Texto");
		Text text = bookService.addText(lorem, words);
		System.out.println(text);
		line();
		Iterable<Word> showWords = bookService.showWorlds();
		System.out.println(showWords);
		line();
	}

	private void line() {
		System.out.println();
		System.out.println("=============================================================");
		System.out.println();
	}
}
