package codegym.repository;

import codegym.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category ,Integer> {
    Category findById(int id);
}
