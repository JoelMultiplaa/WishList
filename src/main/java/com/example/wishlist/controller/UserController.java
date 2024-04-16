package com.example.wishlist.controller;
import com.example.wishlist.model.User;
import com.example.wishlist.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private  UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String showRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        boolean added = userRepository.addUser(user);
        if (added) {
            return "redirect:/login"; //Brugeren blev oprettet, redirect til login-siden
        } else {
            model.addAttribute("error", "Username already exists");
            return "register"; //Brugeren eksisterer allerede, vis registreringsside igen med fejlmeddelelse
        }
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("id") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Model model) {
        // Kontroller, om brugeren er logget ind ved at kalde login-metoden fra userRepository
        if (userRepository.login(username, password)) {
            // Opretter en session for brugeren og sæt session timeout til 30 sekunder
            session.setAttribute("user", username);
            session.setMaxInactiveInterval(30); // Angiv session timeout til 30 sekunder
            return "redirect:/"; // Redirect til startsiden
        } else {
            // Hvis login mislykkes, vis en fejlbesked til brugeren på login-siden
            model.addAttribute("error", "Invalid username or password");
            return "redirect:/login"; // Vis login-formularen igen
        }
    }
}
