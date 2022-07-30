package com.group11.geektext.Controller;

import com.group11.geektext.Models.CreditCard;
import com.group11.geektext.Repo.CreditCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users/{username}/creditCards")
public class CreditCardController {

    @Autowired
    private CreditCardRepo creditCardRepo;

    @GetMapping
    public List<CreditCard> getAllUserCreditCards(@PathVariable(name = "username")String email) {
        return creditCardRepo.getAllUserCreditCardsByEmail(email);
    }

    @PostMapping
    public ResponseEntity<String> createCreditCard(@PathVariable(name = "username")String email, @RequestBody CreditCard creditCard) {
        List<CreditCard> creditCards = creditCardRepo.getCreditCardByCardAndEmail(creditCard.getCreditCardNumber(), email);
        if(creditCards == null || creditCards.size() == 0) {
            creditCard.setEmail(email);
            creditCardRepo.save(creditCard);
            return new ResponseEntity<>("Credit card details saved successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credit card details are already present", HttpStatus.BAD_REQUEST);
        }
    }
}
