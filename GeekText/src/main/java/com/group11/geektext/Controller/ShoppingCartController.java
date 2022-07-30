package com.group11.geektext.Controller;

import com.group11.geektext.Models.CartItem;
import com.group11.geektext.Repo.CartItemRepo;
import com.group11.geektext.Repo.ShoppingCartRepo;
import com.group11.geektext.Models.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepo shoppingCartRepo;

    @Autowired
    private CartItemRepo cartItemRepo;


    //show shopping cart
    @GetMapping(value = "/{username}")
    public ResponseEntity showCart(@PathVariable(value = "username")String email) {

        List<ShoppingCart> shoppingCarts = shoppingCartRepo.getShoppingCartByEmail(email);
        if(shoppingCarts != null && shoppingCarts.size() > 0) {
            ShoppingCart shoppingCart = shoppingCarts.get(0);
            List<CartItem> cartItems = cartItemRepo.getCartItemsByCartId(shoppingCart.getCartId());
            shoppingCart.setCartItems(cartItems);
            return new ResponseEntity<>(shoppingCarts.get(0), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Shopping cart found with email "+email);
        }
    }

    @PostMapping("/{username}")
    public ResponseEntity<String> createShoppingCart(@PathVariable(name = "username")String email) {

        List<ShoppingCart> shoppingCarts = shoppingCartRepo.getShoppingCartByEmail(email);
        if(shoppingCarts == null || shoppingCarts.size() == 0) {
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setEmail(email);
            shoppingCartRepo.save(shoppingCart);
            return new ResponseEntity("Shopping cart created successfully...!!!", HttpStatus.OK);
        } else {
            return new ResponseEntity("Shopping cart already present with given email", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{username}/addBook")
    public ResponseEntity<String> addBookToShoppingCart(@PathVariable(name = "username")String email, @RequestBody List<CartItem> cartItems) {
        List<ShoppingCart> shoppingCarts = shoppingCartRepo.getShoppingCartByEmail(email);
        if(shoppingCarts == null || shoppingCarts.size() == 0) {
            return new ResponseEntity("Shopping cart not present with given email", HttpStatus.BAD_REQUEST);
        } else {
            int cartId = shoppingCarts.get(0).getCartId();
            for(CartItem cartItem : cartItems) {
                cartItem.setCartId(cartId);
                cartItemRepo.save(cartItem);
            }
            return new ResponseEntity<>("Book(s) got added to shopping cart", HttpStatus.OK);
        }
    }

    @PutMapping("/{username}/deleteBook/{bookISBN}")
    public ResponseEntity<String> deleteBookFromShoppingCart(@PathVariable(name = "username")String email,
                                                             @PathVariable(value = "bookISBN")String bookISBN) {
        List<ShoppingCart> shoppingCarts = shoppingCartRepo.getShoppingCartByEmail(email);
        if(shoppingCarts == null || shoppingCarts.size() == 0) {
            return new ResponseEntity("Shopping cart not present with given email", HttpStatus.BAD_REQUEST);
        } else {
            int cartId = shoppingCarts.get(0).getCartId();
            List<CartItem> cartItems = cartItemRepo.getCartItemByCartIdAndBookISBN(cartId, bookISBN);
            if(cartItems == null || cartItems.size() == 0) {
                return new ResponseEntity("Book is not present", HttpStatus.BAD_REQUEST);
            } else {
                cartItemRepo.delete(cartItems.get(0));
                return new ResponseEntity<>("Book got deleted successfully...!!!", HttpStatus.OK);
            }
        }
    }
}
