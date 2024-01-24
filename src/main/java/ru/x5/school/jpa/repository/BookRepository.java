package ru.x5.school.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.x5.school.jpa.model.Author;
import ru.x5.school.jpa.model.Book;
import ru.x5.school.jpa.model.Genre;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookByName(String name);
    List<Book> findByAuthorName(Long authorId);
    List<Book> findByAuthorLastName(String lastName);
    List<Book> findBooksByGenres(@Param("genres") List<Genre> genres);
}
