package codegym.controller;

import codegym.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaculatorController {
    @Autowired
    ICaculatorService iCaculatorService  ;

    @GetMapping("")
    public String Calculator() {
        return "index";
    }

    @GetMapping("caculator")
    public ModelAndView resultCaculator(@RequestParam String num1 ,String num2 ,String operator){
        return new ModelAndView("index" , "result" ,iCaculatorService.caculator(num1,num2,operator));
    }
}
