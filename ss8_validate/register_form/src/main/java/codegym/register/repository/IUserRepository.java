package codegym.register.repository;

import codegym.register.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User , Integer> {
    Page<User> findAll(Pageable pageable) ;
}
