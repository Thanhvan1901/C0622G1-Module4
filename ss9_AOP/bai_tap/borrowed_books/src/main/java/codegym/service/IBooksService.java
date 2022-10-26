package codegym.service;

import codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBooksService {
    Page<Book> findAll(Pageable pageable);
    List<Book> findAll();
    void save(Book book);
    Book findById(int id);
}
