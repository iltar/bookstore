package com.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BookController {
    
    //http://localhost:8080/index
    @GetMapping("/index")
    public String getMethodName(Model model) {
        return "index"; //index.html
    }
    
}
