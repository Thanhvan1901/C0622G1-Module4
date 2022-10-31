package codegym.repposiroty;

import codegym.dto.BlogDto;
import codegym.dto.IBlogDto;
import codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from blog where name_blog like %:keyword%",nativeQuery = true)
    Page<Blog> searchByName(@Param("keyword") String name, Pageable pageable);

    @Query(value = "select  * from blog order by date_created DESC ",nativeQuery = true)
    Page<Blog> findAll(Pageable pageable);

    @Query( value = "select b.id as id,b.blog_name as blogName, c.name_category as nameCategory from blog b join category c on b.category = c.id ;"
            ,nativeQuery = true)
    List<IBlogDto> findBlogDtoByName();
}
