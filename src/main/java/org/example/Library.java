package org.example;

import jakarta.data.repository.Delete;
import jakarta.data.repository.Find;
import jakarta.data.repository.Insert;
import jakarta.data.repository.Repository;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.processing.Pattern;

import java.util.List;
import java.util.Optional;

@Transactional @Repository
public interface Library {

    @Find
    Optional<Book> byIsbn(String isbn);

    @Find
    List<Book> byTitle(@Pattern String title);

    @Insert
    void add(Book book);

    @Delete
    void delete(String isbn);
}
