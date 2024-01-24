package ru.x5.school.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x5.school.jpa.model.Author;
import ru.x5.school.jpa.model.Book;
import ru.x5.school.jpa.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final AuthorService authorService;
    private final BookRepository bookRepository;

    @Autowired
    public BookService(AuthorService authorService, BookRepository bookRepository) {
        this.authorService = authorService;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void createBooks() {
        var book = new Book();
        book.setName("Война и Мир");

        Author author = authorService.findAuthorByLastName("Толстой");
        book.setAuthor(author);

        bookRepository.save(book);

        var otherBook = new Book();
        otherBook.setName("Анна Каренина");
        otherBook.setAuthor(author);

        bookRepository.save(otherBook);

        var otherBook3 = new Book();
        otherBook3.setName("Детство");
        otherBook3.setAuthor(author);

        bookRepository.save(otherBook3);

        var otherBook4 = new Book();
        otherBook4.setName("После бала");
        otherBook4.setAuthor(author);

        bookRepository.save(otherBook4);

        var otherBook1 = new Book();
        otherBook1.setName("Вишневый сад");
        Author author1 = authorService.findAuthorByLastName("Чехов");
        book.setAuthor(author1);
        otherBook1.setAuthor(author1);

        bookRepository.save(otherBook1);

        var otherBook2 = new Book();
        otherBook2.setName("Старик и море");
        Author author2 = authorService.findAuthorByLastName("Пушкин");
        book.setAuthor(author2);
        otherBook2.setAuthor(author2);

        bookRepository.save(otherBook2);
    }
    @Transactional
    public Book findBookByName(String name) {
        return bookRepository.findBookByName(name);
    }
    @Transactional
    public List<Book> findByAuthorName(long authorId) {
        return bookRepository.findByAuthorName(authorId);
    }
    @Transactional
    public List<Book> findByAuthorLastName(String lastName) {
        return bookRepository.findByAuthorLastName(lastName);
    }

    @Transactional
    public List<Book> findBooksByGenres(String genreName) {
        return bookRepository.findByAuthorLastName(genreName);
    }
}
