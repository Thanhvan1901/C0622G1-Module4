package codegym.service;

import codegym.model.Borrowed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBorrowedService {
    Page<Borrowed> findAll (Pageable pageable);
    Borrowed findByCode(int code);
    void deleteByCode(int code);
    void save(Borrowed borrowed) ;
}
