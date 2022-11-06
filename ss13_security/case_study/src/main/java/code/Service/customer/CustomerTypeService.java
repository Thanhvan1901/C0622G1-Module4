package codegym.Service.customer;

import codegym.Repository.customer.ICustomerTypeRepository;
import codegym.Service.ICustomerTypeService;
import codegym.model.customer.CustomerType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return this.iCustomerTypeRepository.findAll();
    }
}
