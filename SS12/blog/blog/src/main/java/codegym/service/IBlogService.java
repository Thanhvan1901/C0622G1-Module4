package codegym.service;

import codegym.dto.BlogDto;
import codegym.dto.IBlogDto;
import codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);


    void update(Blog blogs);

    void remove(int id);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findByName(Pageable pageable,String name);

   List<IBlogDto> findBlogDtoByName();
}
