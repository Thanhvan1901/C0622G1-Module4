package codegym.repository;

import codegym.model.Product;

import java.util.List;

public interface IProductManagerRepository {
    List<Product> findAll() ;
    void save (Product produc);
    Product findById(int id) ;
    Product update(Product produc);
    void remove (int id ) ;
    List<Product> search (String name);
}
