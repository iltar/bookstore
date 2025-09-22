package com.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookstore.domain.Book;
import com.bookstore.domain.Category;
import com.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
    private CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    // http://localhost:8080/categorylist
    @RequestMapping(value = "/categorylist")
    public String getCategories(Model model) {
        model.addAttribute("categories", repository.findAll());
        return "categorylist";
    }

    // http://localhost:8080/addbook
    @RequestMapping(value = "/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String saveCategory(Category category) {
        repository.save(category);
        return "redirect:categorylist";
    }

    @RequestMapping(value = "/deletecategory/{id}", method = RequestMethod.GET)
    public String removeCategory(@PathVariable("id") Long categoryId, Model model) {
        repository.deleteById(categoryId);
        return "redirect:../categorylist";
    }
    
}
