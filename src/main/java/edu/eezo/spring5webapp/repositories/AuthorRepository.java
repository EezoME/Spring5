package edu.eezo.spring5webapp.repositories;

import edu.eezo.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
