package codegym.repository;

import codegym.model.Borrowed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowedRepository extends JpaRepository<Borrowed , Integer> {
    Page<Borrowed> findAll(Pageable pageable);
    Borrowed findByCode(int code);
    void deleteByCode(int code);
}
