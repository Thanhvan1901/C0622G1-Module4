package codegym.service;
import codegym.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Optional<Product> findById(long id);

}
