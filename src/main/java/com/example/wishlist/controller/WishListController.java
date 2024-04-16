package com.example.wishlist.controller;
import com.example.wishlist.model.Wish;
import com.example.wishlist.model.WishList;
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
    @PostMapping("/createwish")
    public String createWish(@ModelAttribute("wish") Wish wish) {
        wishListService.createWish(wish);
        return "createWish";
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

    //Create endpoints til wishlist
    @PostMapping("/createwishlist")
    public String createWishList(@ModelAttribute("newWishList") WishList wishList) {
        wishListService.createWishList(wishList);
        return "redirect:/wishlists";
    }

    @PostMapping("/{id}/update")
    public String updateWishList(@PathVariable int id, @ModelAttribute("updatedWishList") WishList updatedWishList) {
        wishListService.updateWishList(id, updatedWishList);
        return "redirect:/wishlists";
    }

    @PostMapping("/{id}/delete")
    public String deleteWishList(@PathVariable int id) {
        wishListService.deleteWishList(id);
        return "redirect:/wishlists";
    }
}



