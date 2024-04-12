package com.example.wishlist.controller;
import com.example.wishlist.model.Wish;
import com.example.wishlist.repository.WishRepository;
import com.example.wishlist.service.WishListService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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

   /* @GetMapping
    public List<Wish> getWish(Model model) {
        List<Wish> wishes = WishListService.getAllWishes();
        return wishes;
    }
}
*/

