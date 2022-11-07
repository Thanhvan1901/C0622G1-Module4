package codegym.controller;

import codegym.model.facility.Facility;
import codegym.service.IFacilityService;
import codegym.service.IFacilityTypeService;
import codegym.service.IRentFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("facility", new Facility());
        model.addAttribute("facilityTypeList",iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentFacilityService.findAll());
        return "/facility/facility-create";
    }

    @PostMapping("/save")
    public String saveFacility(Facility facility ,RedirectAttributes redirectAttributes){
        this.iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("message",
                "successfully added new");
        return "redirect:/facility/list";
    }
}
