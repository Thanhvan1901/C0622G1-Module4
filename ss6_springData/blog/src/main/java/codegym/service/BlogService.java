package codegym.service;

import codegym.model.Blog;
import codegym.repposiroty.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository ;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        iBlogRepository.delete(findById(id));
    }
}
