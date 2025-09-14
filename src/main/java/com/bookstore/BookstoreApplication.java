package com.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bookstore.domain.Book;
import com.bookstore.domain.BookRepository;;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("The Night Circus", "Erin Morgernstern", 
			2012, "978-0-099-55479-0", 16.95));
			repository.save(new Book("Loveless", "Alice Oseman", 
			2020, "978-0-00-824412-5", 16.95));
		};
	}

}
