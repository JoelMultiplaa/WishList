package com.example.wishlist.controller;

import com.example.wishlist.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
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
            return "login"; // Vis login-formularen igen
        }
    }
}
