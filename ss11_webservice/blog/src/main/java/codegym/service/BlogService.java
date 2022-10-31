package codegym.service;

import codegym.dto.BlogDto;
import codegym.dto.IBlogDto;
import codegym.model.Blog;
import codegym.repposiroty.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository ;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        iBlogRepository.delete(findById(id));
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByName(String name,Pageable pageable) {
        return iBlogRepository.searchByName(name,pageable);
    }

    @Override
    public List<IBlogDto> findBlogDtoByName() {
        return iBlogRepository.findBlogDtoByName();
    }
}
