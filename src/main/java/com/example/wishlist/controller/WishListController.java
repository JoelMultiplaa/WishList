package com.example.wishlist.controller;
import com.example.wishlist.model.Wish;
import com.example.wishlist.repository.WishRepository;
import com.example.wishlist.service.WishListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    // Vis alle ønsker
    @GetMapping("/wishes")
    public String showAllWishes(Model model) {
        model.addAttribute("wishes", wishListService.getAllWishes());
        return "wishes";
    }

    // Vis form til oprettelse af et nyt ønske
    /*@GetMapping("/wishes/new")
    public String showCreateWishForm(Model model) {
        model.addAttribute("wish", new Wish());
        return "create-wish";
    }*/

    // Opret et nyt ønske
    @PostMapping("/wishes")
    public String createWish(@ModelAttribute("wish") Wish wish) {
        wishListService.createWish(wish);
        return "redirect:/wishes";
    }

    // Vis form til redigering af et ønske
    @GetMapping("/wishes/{id}/edit")
    public String showEditWishForm(@PathVariable int id, Model model) {
        Wish wish = wishListService.getWishById(id);
        if (wish == null) {
            return "redirect:/wishes";
        }
        model.addAttribute("wish", wish);
        return "edit-wish";
    }

    // Rediger et ønske
    @PutMapping("/wishes/{id}")
    public String editWish(@PathVariable int id, @ModelAttribute("updatedWish") Wish updatedWish) {
        wishListService.updateWish(id, updatedWish);
        return "redirect:/wishes";
    }

    // Slet et ønske
    @DeleteMapping("/wishes/{id}")
    public String deleteWish(@PathVariable int id) {
        wishListService.deleteWish(id);
        return "redirect:/wishes";
    }
}


