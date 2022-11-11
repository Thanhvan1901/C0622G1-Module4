package codegym.controller;

import codegym.model.contract.Contract;
import codegym.model.contract.ContractDetail;
import codegym.service.*;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IAttachFacilityService iAttachFacilityService;
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 3)Pageable pageable , Model model){
        model.addAttribute("contractList", iContractService.findAllDto(pageable));
        model.addAttribute("attachFacilityList", iAttachFacilityService.findAll());
        model.addAttribute("contractDetailList", iContractDetailService.findAll());
        model.addAttribute("facilityList", iFacilityService.findAll());
        model.addAttribute("employeeList", iEmployeeService.findAll());
        model.addAttribute("customerList", iCustomerService.findAll());
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("contractList", iContractService.findAllDto(pageable));
        return "/contract/Contract";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("contractDto", new Contract());
        model.addAttribute("customerList", iCustomerService.findAll());
        model.addAttribute("facilityList", iFacilityService.findAll());
        return "contract/create";
    }

    @PostMapping("/save")
    public String saveContract(Contract contract, Model model , RedirectAttributes redirectAttributes) {


        model.addAttribute("customerList", iCustomerService.findAll());
        model.addAttribute("facilityList", iFacilityService.findAll());

        iContractService.save(contract);

        redirectAttributes.addFlashAttribute("mess", "Add new successful!");
        return "redirect:/contract";
    }
}
