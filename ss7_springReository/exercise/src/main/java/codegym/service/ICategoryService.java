package codegym.service;

import codegym.model.Blog;
import codegym.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService  {
    List<Category> findAll();

    void save(Category category);

    Category findById(int id);


    void update(Category category);

    void remove(int id);
}
