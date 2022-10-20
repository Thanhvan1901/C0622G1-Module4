package codegym.controller;

import codegym.model.Blog;
import codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService ;

    @GetMapping("/")
    public ModelAndView showList (){
        return new ModelAndView("/index" ,"blogList", iBlogService.findAll());
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog" , new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public  String save(Blog blog){
        blog.setId((int) (Math.random()*1000));
        iBlogService.save(blog);
        return"redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit (@PathVariable int id ,Model model){
        model.addAttribute("blog" , iBlogService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog){
        iBlogService.update(blog);
        return"redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String delete(Blog blog , RedirectAttributes redirect){
        iBlogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view (@PathVariable int id , Model model){
        model.addAttribute("blogview" , iBlogService.findById(id));
        return "/view" ;
    }
}
