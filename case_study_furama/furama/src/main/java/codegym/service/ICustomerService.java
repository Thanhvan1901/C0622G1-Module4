package codegym.service;

import codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    Page<Customer> findAllByNameContaining(String name,String email, String customerType , Pageable pageable);
//    Page<Customer> findAllByNameContaining( String isDelete, Pageable pageable);
    List<Customer> findAll();
    void save(Customer customer);

    Customer findById(int id);

    void deleteById(int deleteId);
}
