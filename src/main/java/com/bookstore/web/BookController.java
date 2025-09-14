package com.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.domain.BookRepository;


@Controller
public class BookController {
    private BookRepository repository;
	public BookController(BookRepository repository) {
		this.repository = repository;
	}

    
    //http://localhost:8080/index
    @GetMapping("/index")
    public String getFrontPage(Model model) {
        return "index"; //index.html
    }

    //http://localhost:8080/booklist
    @RequestMapping(value= {"/", "/booklist"})
    public String getBooks(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist"; //booklist.html
    }
}
