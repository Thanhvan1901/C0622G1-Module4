package codegym.register.service;

import codegym.register.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    List<User> findAllUser() ;
    Page<User> findAll(Pageable pageable);
    void save(User user);
}
