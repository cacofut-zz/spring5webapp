/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.repositories;

import br.com.diagnosticit.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cristianoca
 */
public interface BookRepository extends CrudRepository<Book, Long>{
    
}
