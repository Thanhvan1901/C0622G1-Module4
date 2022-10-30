package codegym.repository;

import codegym.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    Optional<Product> findById(long id);
}
