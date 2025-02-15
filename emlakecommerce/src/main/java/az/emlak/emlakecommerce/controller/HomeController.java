package az.emlak.emlakecommerce.controller;

import az.emlak.emlakecommerce.dtos.category.CategoryDto;
import az.emlak.emlakecommerce.model.Category;
import az.emlak.emlakecommerce.model.Property;
import az.emlak.emlakecommerce.model.Testimonial;
import az.emlak.emlakecommerce.repositories.CategoryRepository;
import az.emlak.emlakecommerce.services.CategoryService;
import az.emlak.emlakecommerce.services.ContactService;
import az.emlak.emlakecommerce.services.PropertyService;
import az.emlak.emlakecommerce.services.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private final PropertyService propertyService;
    private final CategoryService categoryService;
    private final TestimonialService testimonialService;
    private final ContactService contactService;


    public HomeController(PropertyService propertyService, CategoryService categoryService, TestimonialService testimonialService, ContactService contactService) {
        this.propertyService = propertyService;
        this.categoryService = categoryService;
        this.testimonialService = testimonialService;
        this.contactService = contactService;
    }


    @GetMapping("/")
    public String index(Model model){
        List<Category> categories = categoryService.getHomeCategories();
        List<Property> properties = propertyService.getHomeProperties();
        List<Testimonial> testimonials = testimonialService.getAllTestimonials();
        model.addAttribute("properties", properties);
        model.addAttribute("categories",categories);
        model.addAttribute("testimonials",testimonials);
        model.addAttribute("contact", contactService.getContactInfo());

        return "home";
    }
}
