package sk.fri.uniza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sk.fri.uniza.model.Zamestnanec;
import sk.fri.uniza.service.ZamestnanecService;

@Controller
public class ZamestnanecController {
    @Autowired
    private ZamestnanecService service;

    @GetMapping(value = "/zamestnanci")
    public String viewAll(Model model) {
        model.addAttribute("list", service.getListAll());
        return "vsetci";
    }

    @GetMapping(value = "/zamestnanci/novy")
    public String vratFormular(Model model) {
        model.addAttribute("zam", new Zamestnanec());
        return "zamestnanec_form";
    }

    @PostMapping("/zamestnanci/uloz")
    public String ulozZamestnanca(Zamestnanec zamestnanec, RedirectAttributes ra) {
        service.uloz(zamestnanec);
        ra.addFlashAttribute("message","Zamestanaec bol uspesne pridany!");
        return "redirect:/zamestnanci";
    }
}
