package com.group11.geektext.Repo;

import com.group11.geektext.Models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepo extends JpaRepository<CartItem, Integer> {

    @Query("from CartItem where cartId = ?1 and bookISBN = ?2")
    public List<CartItem> getCartItemByCartIdAndBookISBN(int cartId, String bookISBN);

    @Query("from CartItem where cartId = ?1")
    public List<CartItem> getCartItemsByCartId(int cartId);
}
