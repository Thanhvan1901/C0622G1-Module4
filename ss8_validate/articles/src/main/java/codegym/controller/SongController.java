package codegym.controller;

import codegym.dto.SongDto;
import codegym.model.Song;
import codegym.service.ISongService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {

    @Autowired
    private ISongService iSongService ;

    @GetMapping("")
    public String songList(@PageableDefault(value = 3) Pageable pageable, Model model){
        model.addAttribute("songList", iSongService.findAll(pageable));
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("songDto", new SongDto());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated SongDto songDto, BindingResult bindingResult , Model model,
                       RedirectAttributes redirectAttributes){
        new SongDto().validate(songDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/create";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("message","Add New Success");
            return "redirect:/";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("songDto", iSongService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/edit";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            iSongService.update(song);
            redirectAttributes.addFlashAttribute("message", "edit successfully!");
            return "redirect:/";
        }
    }
}

