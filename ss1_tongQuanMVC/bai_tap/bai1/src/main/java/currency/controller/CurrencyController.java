package currency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;

@Controller
public class CurrencyController {
    @GetMapping("")
    public String index(){
        return "index" ;
    }
    @PostMapping("/result")
    public String result(@RequestParam int usd , Model model){
        int result = usd * 23000 ;
        model.addAttribute("result" , result) ;
        model.addAttribute("usd" , usd) ;
        return "index" ;
    }
}
