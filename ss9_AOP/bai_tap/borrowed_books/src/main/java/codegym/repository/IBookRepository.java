package codegym.repository;

import codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findAll(Pageable pageable);
    Book findById(int id);
}
