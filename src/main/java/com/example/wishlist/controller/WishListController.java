package com.example.wishlist.controller;
import com.example.wishlist.model.Wish;
import com.example.wishlist.repository.WishRepository;
import com.example.wishlist.service.WishListService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WishListController {
    private WishListService wishListService;




    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;

    }


    @GetMapping("/Home")
    public String home(Model model) {
        model.addAttribute("user", new Object());
        return "home";
    }


    // Create endpoint
    @PostMapping("/create")
    public String createWish(@ModelAttribute("wish") Wish wish) {
        wishListService.createWish(wish);
        return "redirect:/wishes";
    }

    @GetMapping("/read/{id}")
    public String getWish(@PathVariable("id") int id, Model model) {
        Wish wish = wishListService.getWishById(id);
        model.addAttribute("wish", wish);
        return "wish_details"; // Opret en ønskevisningsside
    }

    @PostMapping("/update/{id}")
    public String updateWish(@PathVariable("id") int id, @ModelAttribute("updatedWish") Wish updatedWish) {
        wishListService.updateWish(id, updatedWish);
        return "redirect:/wishes";
    }

    @PostMapping("/delete/{id}")
    public String deleteWish(@PathVariable("id") int id) {
        wishListService.deleteWish(id);
        return "redirect:/wishes";
    }
}



