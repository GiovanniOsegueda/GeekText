package com.group11.geektext.Repo;

import com.group11.geektext.Models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Long> {

    @Query("delete from ShoppingCart where userId = ?1")
    public void deleteShoppingCartsByUserId(int userId);
}
