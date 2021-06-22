package com.marvel.tail;
import com.marvel.tail.domain.agregates.document.services.DocumentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class TailApplication {

	public static void main(String[] args) {
		SpringApplication.run(TailApplication.class, args);
	}


//	public static void main(String Args[]) throws IOException {
//		System.out.print("Enter path for input files ");
//		Scanner scan = new Scanner(System.in);
//		DocumentService.processDocuments(scan);
//	}
}
