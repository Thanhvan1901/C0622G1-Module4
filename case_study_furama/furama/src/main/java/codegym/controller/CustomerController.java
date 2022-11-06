package codegym.controller;
import codegym.Service.ICustomerService;
import codegym.Service.ICustomerTypeService;
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


    @GetMapping("/")
    public String goCustomerList(@PageableDefault(value = 3) Pageable pageable,
                                 @RequestParam(value = "name"  , defaultValue = "") String name,
                                 @RequestParam(value = "email"  , defaultValue = "") String email,
                                 @PathVariable int id,
                                 Model model) {


        model.addAttribute("customers",
                this.iCustomerService.findAllByNameContaining(name , email, id, pageable));
        model.addAttribute("name", name);
        return "customer/customer-list";
    }

    @GetMapping("/create")
    public String goCreateForm(Model model) {

        model.addAttribute("customer", new Customer());

        model.addAttribute("customerTypeList",
                this.iCustomerTypeService.findAll());

        return "customer/customer-create";
    }

    @PostMapping("/save")
    public String saveCustomer(Customer Customer ,RedirectAttributes redirectAttributes,
                               Model model) {

            this.iCustomerService.save(Customer);

            redirectAttributes.addFlashAttribute("message",
                    "successfully added new");

            return "redirect:/customer/";
        }


    @GetMapping("/edit")
    public String goEditForm(@RequestParam int id,
                             Model model) {

        Customer customer = iCustomerService.findById(id);

        model.addAttribute("customerTypeList",
                this.iCustomerTypeService.findAll());

        return "/customer/customer-edit";
    }

    @PostMapping("/update")
    public String updateCustomer( Customer customer ,RedirectAttributes redirectAttributes , Model model) {


            this.iCustomerService.save(customer);

            redirectAttributes.addFlashAttribute("message",
                    "successfully added new");

            return "redirect:/customer/";
        }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam (value = "deleteId")int id) {

        this.iCustomerService.deleteById(id);
        return "redirect:/customer/";
    }
}
