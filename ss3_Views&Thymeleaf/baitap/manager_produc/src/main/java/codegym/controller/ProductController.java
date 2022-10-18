package codegym.controller;

import codegym.model.Product;
import codegym.service.IProducManagerService;
import codegym.service.ProducManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {
    private final IProducManagerService producManagerService = new ProducManagerService();

    @GetMapping("")
    public String index(Model model){
        List<Product> productList = producManagerService.findAll();
        model.addAttribute("productList" ,productList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product){
        product.setId((int) (Math.random() * 10000));
        producManagerService.save(product);
        return"redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("product" , producManagerService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product){
        producManagerService.update( product);
        return "redirect:/" ;
    }

    @GetMapping("/{id}/delete")
    public String delete(Product product , RedirectAttributes redirect){
        producManagerService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
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
