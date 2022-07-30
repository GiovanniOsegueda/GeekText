package com.group11.geektext.Repo;


import com.group11.geektext.Models.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WishListRepo extends JpaRepository<WishList, Integer>{

    @Query("FROM WishList WHERE userEmail = ?1")
    List<WishList> fetchWishListForUserWithEmail(String email);

    @Query("from WishList WHERE userEmail = ?1 and wishListName =?2")
    public List<WishList> getWishListsByUserEmailAndWishListName(String email, String wishListName);

    @Query("FROM WishList WHERE userEmail = ?1 and wishListName =?2 and bookName = ?3")
    public List<WishList> getWishListsByUserEmailAndWishListNameAndBookName(String email, String wishListName, String bookName);

    @Query("delete from WishList WHERE userEmail = ?1 and wishListName =?2 and bookName = ?3")
    public void deleteWishListsByUserEmailAndWishListNameAAndBookName(String email, String wishListName, String bookName);
}
