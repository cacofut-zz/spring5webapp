/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.bootstrap;

import br.com.diagnosticit.domain.Author;
import br.com.diagnosticit.domain.Book;
import br.com.diagnosticit.domain.Publisher;
import br.com.diagnosticit.repositories.AuthorRepository;
import br.com.diagnosticit.repositories.BookRepository;
import br.com.diagnosticit.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author cristianoca
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

            
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();        
    }
    
    
    private void initData(){
        
        Publisher publisher = new Publisher( "Rua Ernest Renam" , "Christopher");
        publisherRepository.save( publisher );
        
        Author eric = new Author("Cristiano", "Amaral");
        Book ddd    = new Book( "Domain Driver Design", "1234", publisher ); 
        
        eric.getBooks().add( ddd );
        ddd.getAuthors().add( eric );
        
        authorRepository.save( eric );
        bookRepository.save( ddd );
        
        Author road = new Author("Road", "Amaral");
        Book noEJB  = new Book( "J2EE Development without EJB", "1234", publisher );  
        
        road.getBooks().add( noEJB );
        noEJB.getAuthors().add( road );
        
        authorRepository.save( road );
        bookRepository.save( noEJB );
        
    }
}
