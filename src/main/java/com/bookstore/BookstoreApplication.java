package com.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bookstore.domain.Book;
import com.bookstore.domain.BookRepository;
import com.bookstore.domain.Category;
import com.bookstore.domain.CategoryRepository;;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository br, CategoryRepository cr) {
		return (args) -> {
			cr.save(new Category("Fantasy"));
			cr.save(new Category("Contemporary"));

			br.save(new Book("The Night Circus", "Erin Morgernstern", 
			2012, "978-0-099-55479-0", 16.95));
			br.save(new Book("Loveless", "Alice Oseman", 
			2020, "978-0-00-824412-5", 16.95));
		};
	}

}
