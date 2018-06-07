package edu.eezo.spring5webapp.bootstrap;

import edu.eezo.spring5webapp.model.Author;
import edu.eezo.spring5webapp.model.Book;
import edu.eezo.spring5webapp.model.Publisher;
import edu.eezo.spring5webapp.repositories.AuthorRepository;
import edu.eezo.spring5webapp.repositories.BookRepository;
import edu.eezo.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        // Eric
        Author eric = new Author("Eric", "Evans");
        Publisher publisher = new Publisher("Publ 1", "address 1");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(publisher);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher publisher1 = new Publisher("Publ 2", "Address 2");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher1);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        publisherRepository.save(publisher1);
        bookRepository.save(noEJB);
    }
}
