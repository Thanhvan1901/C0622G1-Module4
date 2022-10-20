package codegym.service;

import codegym.model.Product;

import java.util.List;

public interface IProducManagerService {
    List<Product> findAll() ;
    void save (Product produc);
    Product findById(int id) ;
    void update( Product produc);
    void remove (int id ) ;
    List<Product> search (String name);
}
