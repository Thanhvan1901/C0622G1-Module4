package codegym.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class SandwichController {

    @GetMapping("/")
    public String showList() {
        return "index";
    }

    @GetMapping("/condiments")
    public String chooseCondiments(@RequestParam String[] condiments, ModelMap modelMap) {
        modelMap.addAttribute("condiments" ,condiments);
        return "index";
    }
}
