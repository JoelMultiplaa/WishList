package com.example.wishlist.controller;
import com.example.wishlist.model.User;
import com.example.wishlist.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private UserRepository userService;

    public UserController(UserRepository userService) {

        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegister(){

        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        System.out.println(user);
        User addedUser = userService.createUser(user); // Her får vi den oprettede bruger tilbage fra userService
        System.out.println("Test12");
        if (addedUser != null) {
            // Brugeren blev oprettet korrekt
            return "redirect:/wishlist_frontpage";
        } else {
            model.addAttribute("error", "Username already exists");
            return "redirect:/login";
        }
    }



    @GetMapping("/login")
    public String showLogin() {

        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, HttpSession session, Model model) {
        // Kontroller, om brugeren er logget ind ved at kalde login-metoden fra userService
        if (userService.login(user.getUsername(), user.getPassword())) {
            // Opretter en session for brugeren og sæt session timeout til 30 sekunder
            session.setAttribute("user", user.getUsername());
            session.setMaxInactiveInterval(30); // Angiv session timeout til 30 sekunder
            return "redirect:/wishlist_frontpage"; // Redirect til startsiden
        } else {
            // Hvis login mislykkes, vis en fejlbesked til brugeren på login-siden
            model.addAttribute("error", "Invalid username or password");
            return "redirect:/login"; // Vis login-formularen igen
        }
    }

}


