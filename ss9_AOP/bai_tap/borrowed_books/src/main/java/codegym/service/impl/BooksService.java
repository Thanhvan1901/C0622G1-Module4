package codegym.service.impl;

import codegym.model.Book;
import codegym.repository.IBookRepository;
import codegym.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService implements IBooksService {

    @Autowired
    private IBookRepository iBookRepository ;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id);
    }
}
