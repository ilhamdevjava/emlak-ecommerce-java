package az.emlak.emlakecommerce.controller;

import az.emlak.emlakecommerce.model.About;
import az.emlak.emlakecommerce.repositories.AboutRepository;
import az.emlak.emlakecommerce.services.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AboutController {

    @Autowired
    private final AboutService aboutService;

    public AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }


    @GetMapping ("/about")
    public String index(Model model) {
        About about =  aboutService.getAboutInfo();
        model.addAttribute("about", about);
        return "about";
    }
}
