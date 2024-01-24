package ru.x5.school.jpa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x5.school.jpa.model.Author;
import ru.x5.school.jpa.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    private static final Logger log = LoggerFactory.getLogger(AuthorService.class);

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public void createAuthors() {
        var author = new Author();
        author.setFirstName("Александр");
        author.setLastName("Пушкин");

        authorRepository.save(author);
    }

    @Transactional
    public Author findAuthorByLastName(String lastName) {
        return authorRepository.findAuthorByLastName(lastName);
    }

    @Transactional
    public void printAuthorAndBooks(String lastName) {
        Author author = findAuthorByLastName("Толстой");

        log.info("Author is {}", author);

        author.getBooks().forEach(b ->
                log.info("Book is {}", b)
        );
    }

    @Transactional
    public List<Author> findAuthorsWithMoreThan3Books() {
         var authors = authorRepository.findAuthorsWithMoreThan3Books();
         authors.forEach(a -> log.info("Author is {}", a));
        return authors;
    }
}
