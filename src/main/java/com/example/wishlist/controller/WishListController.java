package com.example.wishlist.controller;

import com.example.wishlist.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Merge
// Hej
@Controller
public class WishListController {
    private UserRepository userRepository;

    public WishListController(UserRepository userRepository) {//
         this.userRepository = userRepository;
    }

    private boolean isLoggedIn(HttpSession session) {// kontrollerer, om en bruger er logget ind ved at tjekke, om der er en gyldig bruger i sessionen. Den returnerer true, hvis en bruger er logget ind, ellers returnerer den false.
        return session.getAttribute("user") !=null;

}

//Tilføj endpoints
@GetMapping("")
public String index() {
    //returnerer startside
    return "index";
}

@GetMapping("/login")
public String showLogin() {
    //returnerer login form
    return "login";
}

@PostMapping("/login")
public String login(RequestParam("id") String id,
    @RequestParam("password") String password, HttpSession session, Model model)
        {
if (userService.login(id, password)) {
    //lav en session for bruger og sæt session timeout til 30 sekunder
        session.setAttribute("user", new User(id, password));

        }
        }
