/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.controller;

import br.com.diagnosticit.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author cristianoca
 */
@Controller
public class BookController {
    
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
            
    @RequestMapping("/books")
    public String findAllBooks( Model model ){
        model.addAttribute( "books", bookRepository.findAll() );
        return "books";
    }
}
