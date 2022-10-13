package translate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import translate.model.Translate;
import translate.service.ITranslateService;

import javax.xml.ws.Service;
import java.util.List;

@Controller

public class TranslateController {

    @Autowired
    private ITranslateService iTranslateService;

    @GetMapping("/")
    public String seach() {
        return "index";
    }

    @PostMapping("/search")
    public String meaing(@RequestParam String keyword, Model model) {
        List<Translate> dictionaryLanguages = iTranslateService.findAll();
        for (int i = 0; i < dictionaryLanguages.size(); i++) {
            if (keyword.equalsIgnoreCase(dictionaryLanguages.get(i).getEnglish())) {
                model.addAttribute("word", dictionaryLanguages.get(i).getVietNamese());
                model.addAttribute("key", keyword);
                break;
            } else {
                model.addAttribute("word", "Not Found !");
            }
        }
        return "/index";
    }
}
