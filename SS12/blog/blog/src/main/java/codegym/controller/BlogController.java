package codegym.controller;

import codegym.dto.BlogDto;
import codegym.dto.IBlogDto;
import codegym.model.Blog;
import codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin("*")
public class BlogController {

    @Autowired
    private IBlogService iBlogService ;

//    @GetMapping("")
//    public ResponseEntity<List<Blog>> findAllBlog(){
//        List<Blog> blogs = iBlogService.findAll();
//        if(blogs.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogs , HttpStatus.OK);
//    }

    @GetMapping("")
    public ResponseEntity<Page<Blog>> search(Pageable pageable, @RequestParam (defaultValue ="", required = false) String search){
        Page<Blog> blog = iBlogService.findByName( pageable, search );
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> viewBlog(@PathVariable int id ){
        Blog blogs = iBlogService.findById(id);
        if(blogs == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
}
