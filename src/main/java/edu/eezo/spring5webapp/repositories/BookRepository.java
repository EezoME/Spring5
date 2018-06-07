package edu.eezo.spring5webapp.repositories;

import edu.eezo.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
