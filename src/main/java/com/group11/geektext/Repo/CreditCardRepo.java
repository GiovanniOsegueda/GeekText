package com.group11.geektext.Repo;

import com.group11.geektext.Models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CreditCardRepo extends JpaRepository<CreditCard, Long> {

    @Query("from CreditCard where email = ?1")
    public List<CreditCard> getAllUserCreditCardsByEmail(String email);

    @Query("from CreditCard where creditCardNumber = ?1 and email = ?2")
    public List<CreditCard> getCreditCardByCardAndEmail(String cardNumber, String email);

}
