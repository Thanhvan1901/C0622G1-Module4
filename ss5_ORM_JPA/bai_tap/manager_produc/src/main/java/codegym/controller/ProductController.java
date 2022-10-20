package codegym.controller;

import codegym.model.Product;
import codegym.service.IProducManagerService;
import codegym.service.ProducManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProducManagerService producManagerService ;

    @GetMapping("")
    public ModelAndView index(){
        return new ModelAndView("/index" ,"productList", producManagerService.findAll()) ;
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }
//
    @PostMapping("/save")
    public String save(Product product){
        producManagerService.save(product);
        return"redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("product" , producManagerService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product){
        producManagerService.update( product);
        return "redirect:/product" ;
    }

    @GetMapping("/{id}/delete")
    public String delete(Product product , RedirectAttributes redirect){
        producManagerService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view (@PathVariable int id , Model model){
        model.addAttribute("product" , producManagerService.findById(id));
        return "/view";
    }

    @PostMapping("/search")
    public String search(@RequestParam String name , Model model){
        model.addAttribute("productList" , producManagerService.search(name));
        return "/index" ;
    }

}
