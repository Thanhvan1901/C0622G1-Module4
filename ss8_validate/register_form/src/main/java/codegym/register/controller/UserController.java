package codegym.register.controller;

import codegym.register.dto.UserDto;
import codegym.register.model.User;
import codegym.register.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService ;

    @GetMapping("")
    public String showListUser(@PageableDefault(value = 3)Pageable pageable, Model model){
        model.addAttribute("userList" , iUserService.findAll(pageable));
        return "form/index" ;
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("userDto",new UserDto());
        return "form/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult , Model model,
                       RedirectAttributes redirectAttributes){
        new UserDto().validate(userDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "form/create";
        }else {
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            iUserService.save(user);
            redirectAttributes.addFlashAttribute("message","Add New Success");
            return "redirect:/";
        }
    }
}
