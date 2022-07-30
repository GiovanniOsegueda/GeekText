package com.group11.geektext.Repo;

import com.group11.geektext.Models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Integer> {

    @Query("delete from ShoppingCart where email = ?1")
    public void deleteShoppingCartsByUserId(int userId);

    @Query("from ShoppingCart where email = ?1")
    public List<ShoppingCart> getShoppingCartByEmail(String email);

}
