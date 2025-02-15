package az.emlak.emlakecommerce.controller;

import az.emlak.emlakecommerce.model.Contact;
import az.emlak.emlakecommerce.model.Message;
import az.emlak.emlakecommerce.services.ContactService;
import az.emlak.emlakecommerce.services.MessageService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    private final ContactService contactService;
    private final MessageService messageService;

    public ContactController(ContactService contactService, MessageService messageService) {
        this.contactService = contactService;
        this.messageService = messageService;
    }


    @GetMapping("/contact")
    public String showContactPage(Model model) {
        model.addAttribute("contact", contactService.getContactInfo());
        model.addAttribute("message", new Message());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitMessage(@Valid @ModelAttribute("message") Message message, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("contact", contactService.getContactInfo());
            return "contact";
        }

        messageService.saveMessage(message);
        messageService.saveMessage(message);
        model.addAttribute("successMessage", "Mesajınız başarıyla gönderildi!");
        model.addAttribute("contact", contactService.getContactInfo());
        model.addAttribute("message", new Message());
        return "contact";
    }
}
