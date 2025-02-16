package az.emlak.emlakecommerce.controller;

import az.emlak.emlakecommerce.dtos.auth.LoginDto;
import az.emlak.emlakecommerce.dtos.auth.RegisterDto;
import az.emlak.emlakecommerce.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDto loginDto, Model model) {
        boolean isAuthenticated = userService.authenticate(loginDto.getEmail(), loginDto.getPassword());

        if (isAuthenticated) {
            return "redirect:/home";// Giriş başarılı, ana sayfaya yönlendir
        }
        model.addAttribute("loginError", "Email və ya şifrə yanlışdır.");
        return "redirect:/?loginError=true"; // Hata mesajı için URL parametresi ekle
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterDto registerDto, Model model) {
        boolean result = userService.register(registerDto);

        if (result) {
            return "redirect:/?showLoginModal=true";
        }

        return "redirect:/?registerError=true";
    }
}
