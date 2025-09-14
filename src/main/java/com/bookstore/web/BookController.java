package com.bookstore.web;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookstore.domain.Book;
import com.bookstore.domain.BookRepository;

@Controller
public class BookController {
    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    // http://localhost:8080/index
    @RequestMapping(value = { "/index" })
    public String getFrontPage(Model model) {
        return "index"; // index.html
    }

    // http://localhost:8080/booklist
    @RequestMapping(value = { "/", "/booklist" })
    public String getBooks(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist"; // booklist.html
    }

    // http://localhost:8080/addbook
    @RequestMapping(value = { "/addbook" })
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook"; // addbook.html
    }

    // save book to database
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:booklist"; // return to booklist
    }

    // remove book from database
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String removeBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../booklist"; // return to booklist
    }

    // edit book
    @RequestMapping(value = "/editbook/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        Optional<Book> b = repository.findById(bookId);
        model.addAttribute("book", b);
        return "editbook"; // editbook.html
    }
}
