package com.example.wishlist.controller;
import com.example.wishlist.model.Wish;
import com.example.wishlist.model.Wishlist;
import com.example.wishlist.service.WishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class WishController {

private WishService wishService;

public WishController (WishService wishService){
    this.wishService = wishService;
}

// Opret ønskeside
@GetMapping("/createwish")
public String createWishPage(Model model) {
    model.addAttribute("wish", new Wish());
    return "createWish"; // Opret en side for oprettelse af ønske
}

// Opret ønske endpoint
@PostMapping("/createwish")
public String createWish(@ModelAttribute("wish") Wish wish) {
    wishService.createWish(wish);
    return "redirect:/wishes"; // Omdiriger til ønskesiden efter oprettelse
}

// Endpoint for visning af alle ønsker
@GetMapping("/wishes")
public String showAllWishes(Model model) {
    List<Wish> wishes = wishService.getAllWishes();
    model.addAttribute("wishes", wishes);
    return "wish_list"; // Opret en side for visning af ønsker
}

// Endpoint for visning af oprettelsesformular for et nyt ønske
@GetMapping("/createwishpage")
public String showCreateWishForm(Model model) {
    model.addAttribute("wish", new Wish());
    return "create_wish"; // Opret en side for oprettelse af ønske
}

@GetMapping("/read/{id}")
public String getWish(@PathVariable("id") int id, Model model) {
    Wish wish = wishService.getWishById(id);
    model.addAttribute("wish", wish);
    return "wish_details"; // Opret en ønskevisningsside
}

@PostMapping("/update/{id}")
public String updateWish(@PathVariable("id") int id, @ModelAttribute("updatedWish") Wish updatedWish) {
    wishService.updateWish(id, updatedWish);
    return "redirect:/wishes";
}

@PostMapping("/delete/{id}")
public String deleteWish(@PathVariable("id") int id) {
    wishService.deleteWish(id);
    return "redirect:/wishes";
}

}
