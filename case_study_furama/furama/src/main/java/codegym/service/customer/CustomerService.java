package codegym.service.customer;

import codegym.repository.customer.ICustomerRepository;
import codegym.service.ICustomerService;
import codegym.model.customer.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public Page<Customer> findAllByNameContaining(String name, String email, String customerType  , Pageable pageable) {
        return iCustomerRepository.findBySearch(name, email, customerType , pageable);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }
//    @Override
//    public Page<Customer> findAllByNameContaining(String isDelete , Pageable pageable) {
//        return iCustomerRepository.findBySearch(isDelete, pageable);
//    }

    @Override
    public void save(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return this.iCustomerRepository.findById(id).get();
    }

    @Override
    public void deleteById(int deleteId) {
        this.iCustomerRepository.delete(deleteId);
    }
}
