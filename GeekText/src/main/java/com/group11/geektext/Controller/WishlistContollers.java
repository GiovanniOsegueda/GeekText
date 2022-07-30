package com.group11.geektext.Controller;

import com.group11.geektext.Models.CartItem;
import com.group11.geektext.Models.ShoppingCart;
import com.group11.geektext.Models.WishList;
import com.group11.geektext.Repo.CartItemRepo;
import com.group11.geektext.Repo.ShoppingCartRepo;
import com.group11.geektext.Repo.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/users/{username}/wishList")
public class WishlistContollers {

    @Autowired
    WishListRepo wishListRepo;

    @Autowired
    private ShoppingCartRepo shoppingCartRepo;

    @Autowired
    private CartItemRepo cartItemRepo;

    @PostMapping
    public ResponseEntity<String> createWishList(@PathVariable(value = "username")String email, @RequestBody WishList wishList) {
        List<WishList> wishLists = wishListRepo.getWishListsByUserEmailAndWishListName(email, wishList.getWishListName());
        if(wishLists == null || wishLists.size()==0) {
            wishList.setUserEmail(email);
            wishListRepo.save(wishList);
            return new ResponseEntity<>("Wishlist with name "+ wishList.getWishListName() + " created", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Wishlist with name "+ wishList.getWishListName() + " is already present", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addBook")
    public ResponseEntity<String> addBookToWishList(@PathVariable(value = "username")String email, @RequestBody WishList wishList) {
        List<WishList> wishLists = wishListRepo.getWishListsByUserEmailAndWishListName(email, wishList.getWishListName());
        if(wishLists == null || wishLists.size() == 0) {
            return new ResponseEntity<>("Wishlist with name "+ wishList.getWishListName() + " does not exist", HttpStatus.BAD_REQUEST);
        } else {
            List<WishList> wishLists1 = wishListRepo.getWishListsByUserEmailAndWishListNameAndBookName(email,
                    wishList.getWishListName(), wishList.getBookName());
            if(wishLists1 == null || wishLists1.size() == 0) {
                wishList.setUserEmail(email);
                wishListRepo.save(wishList);
                return new ResponseEntity<>("Book got added successfully to wishlist", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Book already present in Wishlist with name "+ wishList.getWishListName(), HttpStatus.BAD_REQUEST);
            }
        }
    }

    @GetMapping
    public List<WishList> getAllBooksFromWishList(@PathVariable(value = "username")String email, @RequestParam(value = "wishListName")String wishListName) {
        return wishListRepo.getWishListsByUserEmailAndWishListName(email, wishListName);
    }

    @PutMapping("/deleteBook")
    public ResponseEntity<String> deleteBookFromWishList(@PathVariable(value = "username")String email, @RequestBody WishList wishList) {
        List<WishList> wishLists1 = wishListRepo.getWishListsByUserEmailAndWishListNameAndBookName(email,
                wishList.getWishListName(), wishList.getBookName());
        if(wishLists1 == null || wishLists1.size() == 0) {
            return new ResponseEntity<>("Book with name "+wishList.getBookName()+" is not present in wishList "+ wishList.getWishListName(), HttpStatus.BAD_REQUEST);
        } else {
            wishListRepo.delete(wishLists1.get(0));
            return new ResponseEntity<>("Book got deleted successfully", HttpStatus.OK);
        }
    }

    @PutMapping("/addToCart")
    public ResponseEntity<String> addBookToShoppingCart(@PathVariable(value = "username")String email, @RequestBody WishList wishList) {
        List<WishList> wishLists = wishListRepo.getWishListsByUserEmailAndWishListNameAndBookName(email,
                wishList.getWishListName(), wishList.getBookName());
        ShoppingCart savedCart;
        if(wishLists == null || wishLists.size() == 0) {
            return new ResponseEntity<>("Book with name "+wishList.getBookName()+" is not present in wishList "+ wishList.getWishListName(), HttpStatus.BAD_REQUEST);
        } else {
            wishListRepo.delete(wishLists.get(0));
            List<ShoppingCart> shoppingCarts = shoppingCartRepo.getShoppingCartByEmail(email);
            savedCart = shoppingCarts.get(0);
            if(shoppingCarts == null || shoppingCarts.size() == 0) {
                ShoppingCart shoppingCart = new ShoppingCart();
                shoppingCart.setEmail(email);
                savedCart = shoppingCartRepo.save(shoppingCart);
            }

            CartItem cartItem = new CartItem();
            cartItem.setBookISBN(wishList.getBookName());
            cartItem.setCartId(savedCart.getCartId());
            cartItem.setQuantity(1);
            cartItemRepo.save(cartItem);
        }

        return new ResponseEntity<>("The book got added to your cart", HttpStatus.OK);
    }
}
