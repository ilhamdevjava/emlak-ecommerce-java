package az.emlak.emlakecommerce.controller;

import az.emlak.emlakecommerce.model.Property;
import az.emlak.emlakecommerce.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class ShopController {
    @Autowired
    private final PropertyService propertyService;


    public ShopController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/shop")
    public String index(Model model) {
        List<Property> properties = propertyService.getHomeProperties();
        model.addAttribute("properties", properties);
        return "shop";
    }

}

