package codegym.repository;

import codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    /*
    select * from8 blog where blog_name like %:name%
     */
    Page<Blog> findAllByBlogNameContainingAndOrOrderByDateDesc(String name, Pageable pageable, Sort sort);
}
