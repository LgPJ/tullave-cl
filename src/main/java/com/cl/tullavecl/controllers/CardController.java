package com.cl.tullavecl.controllers;

import com.cl.tullavecl.Dtos.ResponseDto;
import com.cl.tullavecl.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    /**
     *
     * @param cardNumber
     * @return
     * @throws IOException
     */
    @GetMapping("/card/information")
    public ResponseEntity<ResponseDto> getCardInformation(@RequestParam String cardNumber, HttpServletRequest request) throws IOException {
        ResponseDto cardInformation = cardService.getCardInformation(cardNumber, request);
        if (cardInformation.getMessage().equals("error")) {
            return new ResponseEntity<>(cardInformation, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(cardInformation, HttpStatus.OK);
        }
    }

}
