package ru.x5.school.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x5.school.jpa.model.Author;
import ru.x5.school.jpa.model.Book;
import ru.x5.school.jpa.model.Genre;
import ru.x5.school.jpa.repository.BookRepository;
import ru.x5.school.jpa.repository.GenreRepository;


import java.util.List;
@Service
public class GenreService {

    private final AuthorService authorService;
    private final BookService bookService;
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(AuthorService authorService, BookService bookService, GenreRepository genreRepository) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.genreRepository = genreRepository;
    }
    @Transactional
    public void createGenre() {
        var genre = new Genre();
        genre.setName("Художественная литература");
        List<Book> books = bookService.findByAuthorName(2);
        genre.setBooks(books);

        genreRepository.save(genre);
    }


}
