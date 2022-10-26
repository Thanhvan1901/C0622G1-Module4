package codegym.controller;

import codegym.model.Book;
import codegym.model.Borrowed;
import codegym.service.IBooksService;
import codegym.service.IBorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class BooksController {

    @Autowired
    private IBooksService iBooksService ;

    @Autowired
    private IBorrowedService iBorrowedService ;

    @GetMapping("/")
    public String showListBook(@PageableDefault(value = 3)Pageable pageable, Model model){
        model.addAttribute("book" , iBooksService.findAll(pageable));
        model.addAttribute("borrowed" , iBooksService.findAll(pageable));
        return "/index";
    }

    @GetMapping("/borrow/{id}")
    public String borrowedBooks(@PathVariable int id , Model model) throws Exception{
        Book book = iBooksService.findById(id);
        if(book.getTotalBook() == 0){
            throw new Exception();
        }
        model.addAttribute("book" , book);

        return "/borrowed" ;
    }

    @PostMapping("/save")
    public String saveBooks(@ModelAttribute Book book, RedirectAttributes redirectAttributes){
        book.setTotalBook(book.getTotalBook() - 1);
        iBooksService.save(book);
        int code = ((int) (Math.random()*1000));
        Date date = new Date();
        Borrowed borrowed=new Borrowed(code , date.toString(), book );
        iBorrowedService.save(borrowed);
        redirectAttributes.addFlashAttribute("success" , borrowed.getCode());
        return "redirect:/";
    }

    @GetMapping("/give")
    public String showPay(@RequestParam(defaultValue = "") int code, Model model) throws Exception {
        Borrowed borrowed = iBorrowedService.findByCode(code);
        List<Book> books = iBooksService.findAll();
        if(borrowed == null){
            throw new Exception() ;
        }else {
            for (Book book : books) {
                int idBook = book.getId();
                Book idBorrowed = borrowed.getBook();
                if (idBook == Integer.parseInt(String.valueOf(idBorrowed))){
                    book.setTotalBook(book.getTotalBook() + 1);
                    iBooksService.save(book);
                    iBorrowedService.deleteByCode(code);
                }
            }
            return "redirect:/";
        }
    }
//    @PostMapping("/savePay")
//    public String checkPay(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) throws Exception {
//        book.setAmountBook(book.getAmountBook() + 1);
//        iBookService.save(book);
//        redirectAttributes.addFlashAttribute("success" , "Successfully returned the book");
//        return "redirect:/";
//    }
}
