package com.group11.geektext.Repo;


import java.util.List;
import com.group11.geektext.Models.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WishListRepo extends JpaRepository<WishList, String>{

    @Query("SELECT w FROM WishList w WHERE w.id = ?1")
    List<WishList> fetchWishListForUserWithId(long id);


}
