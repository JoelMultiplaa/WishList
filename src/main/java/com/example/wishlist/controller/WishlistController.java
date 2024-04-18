package com.example.wishlist.controller;
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
        return "wishlist_frontpage";
    }

    @GetMapping("/createwishlist")
    public String createWishListPage(Model model) {
        model.addAttribute("wishlistObject", new Wishlist());
        return "createwishlist"; //denne del rammer vi endpointet så vi kommer på url
    }

    // Opret ønskeliste endpoint
    @PostMapping("/createwishlist")
    public String createWishlist(@ModelAttribute("wishlistObject") Wishlist wishlist) {
        System.out.println("test2" + wishlist);
        //wishlistService.creteWishlist(wishlist);

        return "redirect:/wishlist_frontpage";
    }


    // Slet ønskeliste endpoint
    @PostMapping("/deletewishlist/{id}")
    public String deleteWishList(@PathVariable("id") int id) {
        wishlistService.deleteWishList(id);
        return "redirect:/wishlist_frontpage";
    }

// Rediger ønskeliste side
    /*@GetMapping("/editwishlist/{id}")
    public String editWishListPage(@PathVariable("id") int id, Model model) {
        WishList wishList = wishListService.getWishListById(id);
        model.addAttribute("wishList", wishList);
        return "edit_wishlist"; // Opret en side for redigering af ønskeliste
    }*/

    // Opdater ønskeliste endpoint
    @GetMapping("/editwishlist/{id}")
    public String showEditWishlistPage(@PathVariable("id") int id, Model model) {
        // Her kan du tilføje logik til at hente eksisterende ønskelisteoplysninger baseret på id
        // F.eks. kan du bruge en service til at hente ønskelisten fra databasen baseret på id
        Wishlist wishlist = wishlistService.getWishlistById(id);

        // Tilføj ønskelisteoplysningerne til modelen, så de kan bruges i HTML-siden
        model.addAttribute("wishlist", wishlist);

        // Returner navnet på HTML-filen for at vise siden
        return "editwishlist";
    }


    // Vis alle ønskelister endpoint
    @GetMapping("/wishlists")
    public String showAllWishists(Model model) {
        List<Wishlist> wishLists = wishlistService.getAllWishLists();
        model.addAttribute("wishLists", wishLists);
        return "wish_list"; // Opret en side for visning af ønskelister
    }
}


