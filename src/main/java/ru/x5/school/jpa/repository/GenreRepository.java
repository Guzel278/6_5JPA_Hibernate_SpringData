package ru.x5.school.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.x5.school.jpa.model.Book;
import ru.x5.school.jpa.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
