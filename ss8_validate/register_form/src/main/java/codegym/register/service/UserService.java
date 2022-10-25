package codegym.register.service;

import codegym.register.model.User;
import codegym.register.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository iUserRepository ;

    @Override
    public List<User> findAllUser() {
        return iUserRepository.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return iUserRepository.findAll(pageable);
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user) ;
    }
}
