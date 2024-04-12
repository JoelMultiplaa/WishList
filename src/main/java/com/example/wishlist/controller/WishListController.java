package com.example.wishlist.controller;
import com.example.wishlist.model.Wish;
import com.example.wishlist.repository.WishRepository;
import com.example.wishlist.service.WishListService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WishListController {
    private WishListService wishListService;

    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    private WishRepository wishRepository;

    @GetMapping("/Home")
    public String home(Model model) {
        model.addAttribute("user", new Object());
        return "home";
    }

    // Create endpoint
    @PostMapping("")
    public String createWish(@ModelAttribute("wish") Wish wish) {
        wishListService.createWish(wish);
        return "redirect:/wishes";
    }

    // Delete endpoint
    @DeleteMapping("/{id}")
    public String deleteWish(@PathVariable int id) {
        wishListService.deleteWish(id);
        return "redirect:/wishes";
    }

    // Edit endpoint
    @PutMapping("/{id}")
    public String editWish(@PathVariable int id, @ModelAttribute("updatedWish") Wish updatedWish) {
        wishListService.updateWish(id, updatedWish);
        return "redirect:/wishes";
    }

}


/*


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
    @Controller
    @RequestMapping("/wishes")
    public class WishController {
        public class WishListController {
            private UserRepository userRepository;

            public WishListController(UserRepository userRepository) {//
                this.userRepository = userRepository;
            }
        }
         private boolean isLoggedIn(HttpSession session) {// kontrollerer, om en bruger er logget ind ved at tjekke, om der er en gyldig bruger i sessionen. Den returnerer true, hvis en bruger er logget ind, ellers returnerer den false.
        return session.getAttribute("user") != null;
    }
}
    }
}
 */
