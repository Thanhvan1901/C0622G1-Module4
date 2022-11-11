package codegym.controller;
import codegym.dto.CustomerDto;
import codegym.service.ICustomerService;
import codegym.service.ICustomerTypeService;
import codegym.model.customer.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;


    @GetMapping("/home")
    public String goCustomerList(@PageableDefault(value = 3) Pageable pageable,
                                 @RequestParam(value = "name"  , defaultValue = "") String name,
                                 @RequestParam(value = "email"  , defaultValue = "") String email,
                                 @RequestParam (value = "customerType" , defaultValue = "") String customerType,
                                 Model model) {
        model.addAttribute("customerTypeList" , this.iCustomerTypeService.findAll());
        model.addAttribute("customers",
                this.iCustomerService.findAllByNameContaining(name,email,customerType,pageable));
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("customerType", customerType);
        return "customer/customer-list";
    }

    @GetMapping("/create")
    public String goCreateForm(Model model) {

        model.addAttribute("customerDto", new CustomerDto());

        model.addAttribute("customerTypeList",
                this.iCustomerTypeService.findAll());

        return "customer/customer-create";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute @Valid CustomerDto customerDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        new CustomerDto().validate(customerDto, bindingResult);

        if (bindingResult.hasErrors()){
            model.addAttribute("customerTypeList",
                    this.iCustomerTypeService.findAll());
            return "/customer/customer-create";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);

            this.iCustomerService.save(customer);

            redirectAttributes.addFlashAttribute("message",
                    "successfully added new");

            return "redirect:/customer/";
        }
    }


    @GetMapping("/edit/{id}")
    public String goEditForm(@PathVariable int id,
                             Model model) {

        Customer customer = iCustomerService.findById(id);

        CustomerDto customerDto = new CustomerDto();

        BeanUtils.copyProperties(customer,customerDto);

        model.addAttribute("customerDto",
                customerDto);

        model.addAttribute("customerTypeList",
                this.iCustomerTypeService.findAll());
        return "/customer/customer-edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute @Valid CustomerDto customerDto,
                                 BindingResult bindingResult ,
                                 RedirectAttributes redirectAttributes ,
                                 Model model) {

        new CustomerDto().validate(customerDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList",
                    this.iCustomerTypeService.findAll());
            return "/customer/customer-edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            this.iCustomerService.save(customer);

            redirectAttributes.addFlashAttribute("message",
                    "successfully update new");

            return "redirect:/customer/home";
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam (value = "deleteId")int deleteId) {

        this.iCustomerService.deleteById(deleteId);
        return "redirect:/customer/home";
    }
}
