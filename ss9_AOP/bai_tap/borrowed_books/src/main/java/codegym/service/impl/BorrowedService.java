package codegym.service.impl;

import codegym.model.Borrowed;
import codegym.repository.IBookRepository;
import codegym.repository.IBorrowedRepository;
import codegym.service.IBorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BorrowedService implements IBorrowedService {

    @Autowired
    private IBorrowedRepository iBorrowedRepository ;
    @Override
    public Page<Borrowed> findAll(Pageable pageable) {
        return iBorrowedRepository.findAll(pageable);
    }

    @Override
    public Borrowed findByCode(int code) {
        return iBorrowedRepository.findByCode(code);
    }

    @Override
    public void deleteByCode(int code) {
        iBorrowedRepository.deleteByCode(code);
    }

    @Override
    public void save(Borrowed borrowed) {
        iBorrowedRepository.save(borrowed);
    }
}
