package codegym.Service.customer;

import codegym.Repository.customer.ICustomerRepository;
import codegym.Service.ICustomerService;
import codegym.model.customer.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public Page<Customer> findAllByNameContaining(String name, String email, String customerType , String isDelete , Pageable pageable) {
        return iCustomerRepository.findBySearch(name, email, customerType, isDelete , pageable);
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
