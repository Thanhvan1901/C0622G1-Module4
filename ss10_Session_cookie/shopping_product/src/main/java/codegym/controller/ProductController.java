package codegym.controller;
import codegym.dto.CartDto;
import codegym.dto.ProductDto;
import codegym.model.Product;
import codegym.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@SessionAttributes("cart")
@Controller
@RequestMapping(value = "/shop")
public class ProductController {

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @Autowired
    private IProductService iProductService;

    @GetMapping
    public ModelAndView showListPage(Model model, @CookieValue(value = "idProduct", defaultValue = "-1") Long idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", iProductService.findById(idProduct).get());
        }
        return new ModelAndView("product/list", "productList", iProductService.findAll());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable long id, HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(60*1);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("product/detail", "product", iProductService.findById(id).get());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productDetail = iProductService.findById(id);
        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("/delete/{id}")
    public String deleteProductIn(@PathVariable Long id, @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productDetail = iProductService.findById(id);

        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.remove(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/deleteAll/{id}")
    public String delete(@PathVariable Long id, @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productDetail = iProductService.findById(id);

        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.remove(productDto);
        }
        return "redirect:/cart";
    }
}
