package sk.fri.uniza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sk.fri.uniza.exceptions.ZamestnanecNotFoundExcption;
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
        model.addAttribute("title", "Pridavanie noveho zamestnanca");
        return "zamestnanec_form";
    }

    @PostMapping("/zamestnanci/uloz")
    public String ulozZamestnanca(Zamestnanec zamestnanec, RedirectAttributes ra) {
        service.uloz(zamestnanec);
        ra.addFlashAttribute("message", "Zmeny boli uspesne ulozene!");
        return "redirect:/zamestnanci";
    }

    @GetMapping("/zamestnanci/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model, RedirectAttributes ra) {
        try {
            Zamestnanec zamestnanec = service.getZamestnanec(id);
            service.uloz(zamestnanec);
            model.addAttribute("zam", zamestnanec);
            model.addAttribute("title", "Edit zamestnanca s id:" + id);
            return "zamestnanec_form";
        } catch (ZamestnanecNotFoundExcption e) {
            ra.addFlashAttribute("exp", e.getMessage());
        }
        return "redirect:/zamestnanci";
    }

    @GetMapping("/zamestnanci/delete/{id}")
    public String odstranenieZam(@PathVariable("id") int id, RedirectAttributes ra) {
        try {
            service.vymazZamestnanca(id);
            ra.addFlashAttribute("sprava", "Zamestananec bol uspesne odstraneny");
        } catch (ZamestnanecNotFoundExcption e) {
            ra.addFlashAttribute("exp", e.getMessage());
        }
        return "redirect:/zamestnanci";
    }
}
