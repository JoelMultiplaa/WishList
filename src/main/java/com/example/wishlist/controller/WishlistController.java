package com.example.wishlist.controller;
import com.example.wishlist.model.Wish;
import com.example.wishlist.model.Wishlist;
import com.example.wishlist.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class WishlistController {
    private WishlistService wishlistService;

    public WishlistController(WishlistService wishListService) {
        this.wishlistService = wishListService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("user", new Object());
        return "home";
    }

    @GetMapping("/wishlist_frontpage")
    public String showWishListFrontpage(Model model) {
        // Implementer logikken til at hente ønskelister fra backenden og sende dem til HTML-siden
        List<Wishlist> wishLists = wishlistService.getAllWishLists();
        model.addAttribute("wishLists", wishLists);
        return "wishlist_frontpage"; //
    }

    @GetMapping("/createwishlist")
    public String createWishListPage(Model model) {
        model.addAttribute("wishList", new Wishlist());
        return "createwishlist";
    }

    // Opret ønskeliste endpoint
    @PostMapping("/createwishlist")
    public String createWishList(@ModelAttribute("wishList") Wishlist wishList) {
        wishlistService.createWishList(wishList);
        return "redirect:/wishlist_frontpage"; // Omdiriger til ønskeliste-siden efter oprettelse
    }

    // Slet ønskeliste endpoint
    @PostMapping("/deletewishlist/{id}")
    public String deleteWishList(@PathVariable("id") int id) {
        wishlistService.deleteWishList(id);
        return "redirect:/wishlists_frontpage";
    }

// Rediger ønskeliste side
    /*@GetMapping("/editwishlist/{id}")
    public String editWishListPage(@PathVariable("id") int id, Model model) {
        WishList wishList = wishListService.getWishListById(id);
        model.addAttribute("wishList", wishList);
        return "edit_wishlist"; // Opret en side for redigering af ønskeliste
    }*/

    // Opdater ønskeliste endpoint
    @PostMapping("/editwishlist/{id}")
    public String updateWishList(@PathVariable("id") int id, @ModelAttribute("wishList") Wishlist updatedWishList) {
        wishlistService.updateWishList(id, updatedWishList);
        return "redirect:/wishlists";
    }

    // Vis alle ønskelister endpoint
    @GetMapping("/wishlists")
    public String showAllWishists(Model model) {
        List<Wishlist> wishLists = wishlistService.getAllWishLists();
        model.addAttribute("wishLists", wishLists);
        return "wish_list"; // Opret en side for visning af ønskelister
    }
}


