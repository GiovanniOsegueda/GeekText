package com.group11.geektext.Controller;

import com.group11.geektext.Repo.ShoppingCartRepo;
import com.group11.geektext.Models.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepo shoppingCartRepo;


    //show shopping cart by user ID
    @GetMapping(value = "/cart/{id}")
    public String showCart(ShoppingCart model) {
        return null;
    }

    @PostMapping("/{userId}")
    public String createCartForUser(@PathVariable(name = "userId")int userId) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUserId(userId);
        shoppingCart.setQuantity(0);
        shoppingCart.setBookId(null);
        shoppingCartRepo.save(shoppingCart);

        return "Shopping cart created...!!!";
    }

    @PutMapping
    public String updateShoppingCart(@PathVariable(name = "userId")int userId, @RequestBody List<ShoppingCart> shoppingCartList) {

        shoppingCartRepo.deleteShoppingCartsByUserId(userId);



        return "Shopping cart updated/replaced with new details";
    }

}
