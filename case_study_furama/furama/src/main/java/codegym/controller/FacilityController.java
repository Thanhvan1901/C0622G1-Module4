package codegym.controller;

import codegym.dto.CustomerDto;
import codegym.dto.FacilityDto;
import codegym.model.customer.Customer;
import codegym.model.facility.Facility;
import codegym.service.IFacilityService;
import codegym.service.IFacilityTypeService;
import codegym.service.IRentFacilityService;
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
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentFacilityService iRentFacilityService;
    @GetMapping("/list")
    public String showList(@RequestParam(value = "name",defaultValue = "") String name,
                           @RequestParam(value = "facilityType",defaultValue = "") String facilityType,
                           @PageableDefault(value = 3) Pageable pageable,
                           Model model){
        model.addAttribute("name", name);
        model.addAttribute("facilityType", facilityType);
        model.addAttribute("facilityList", this.iFacilityService.findBySearch(name,facilityType,pageable));
        model.addAttribute("facilityTypeList", this.iFacilityTypeService.findAll());
        return "/facility/facility-list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("facility", new FacilityDto());
        model.addAttribute("facilityTypeList",iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentFacilityService.findAll());
        return "/facility/facility-create";
    }

    @PostMapping("/save")
    public String saveFacility(@ModelAttribute @Valid FacilityDto facilityDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model){
        if(facilityDto.getFacilityType().getId() == 1){
            new FacilityDto().validate(facilityDto, bindingResult);
            if (bindingResult.hasFieldErrors()){
                model.addAttribute("facilityTypeList",
                        this.iFacilityTypeService.findAll());

                model.addAttribute("rentTypeList",
                        this.iRentFacilityService.findAll());

                return "facility/facility-create";
            }
//            House
        } else if(facilityDto.getFacilityType().getId()== 2){
            if (bindingResult.hasFieldErrors("facilityType")
                    ||bindingResult.hasFieldErrors("name")
                    || bindingResult.hasFieldErrors("area")
                    || bindingResult.hasFieldErrors("cost")
                    || bindingResult.hasFieldErrors("maxPeople")
                    || bindingResult.hasFieldErrors("rentType")){
                model.addAttribute("facilityTypeList",
                        this.iFacilityTypeService.findAll());

                model.addAttribute("rentTypeList",
                        this.iRentFacilityService.findAll());

                return "facility/facility-create";
            }
        } else if(facilityDto.getFacilityType().getId()== 3){
            new FacilityDto().validate(facilityDto, bindingResult);
            if (bindingResult.hasFieldErrors("facilityType")
                    ||bindingResult.hasFieldErrors("name")
                    || bindingResult.hasFieldErrors("area")
                    || bindingResult.hasFieldErrors("cost")
                    || bindingResult.hasFieldErrors("maxPeople")
                    || bindingResult.hasFieldErrors("descriptionOtherConvenience")
                    || bindingResult.hasFieldErrors("rentType")
                    || bindingResult.hasFieldErrors("poolArea")
                    || bindingResult.hasFieldErrors("standardRoom")){
                model.addAttribute("facilityTypeList",
                        this.iFacilityTypeService.findAll());

                model.addAttribute("rentTypeList",
                        this.iRentFacilityService.findAll());

                return "facility/facility-create";
            }
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        this.iFacilityService.save(facility);

        redirectAttributes.addFlashAttribute("message",
                "successfully update");
        return "redirect:/facility/list";
    }

    @GetMapping("/edit")
    public String editFacility(@RequestParam(value = "id") int id,
                               Model model){
        model.addAttribute("facility", iFacilityService.findById(id));
        model.addAttribute("facilityTypeList",iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentFacilityService.findAll());
        return "/facility/facility-edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute @Valid FacilityDto facilityDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {


        new  FacilityDto().validate(facilityDto , bindingResult);

        if(bindingResult.hasFieldErrors()){
            model.addAttribute("facilityTypeList",
                    this.iFacilityTypeService.findAll());

            model.addAttribute("rentTypeList",
                    this.iRentFacilityService.findAll());

            return "facility/facility-edit";
        }

        Facility facility1 = new Facility();
        BeanUtils.copyProperties(facilityDto,facility1);
        this.iFacilityService.save(facility1);

        redirectAttributes.addFlashAttribute("message",
                "successfully update");
        return "redirect:/facility/list";
    }
    @PostMapping("/delete")
    public String deleteFacility(@RequestParam(value = "deleteId") int id){
        iFacilityService.deleteId(id);
        return "redirect:/facility/list";
    }
}
