package com.cl.tullavecl.services;

import com.cl.tullavecl.Dtos.CardBalanceDto;
import com.cl.tullavecl.Dtos.CardInformationDto;
import com.cl.tullavecl.Dtos.ResponseCardDto;
import com.cl.tullavecl.Dtos.ResponseDto;
import com.cl.tullavecl.utils.PropertiesConnection;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class CardService {

    private final RestTemplate restTemplate;

    public CardService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseDto getCardInformation(String cardNumber) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(new PropertiesConnection().get("bearer.token"));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = new PropertiesConnection().get("path.url") + new PropertiesConnection().get("get.information") + cardNumber;
        ResponseEntity<CardInformationDto> response = restTemplate.exchange(url, HttpMethod.GET, entity, CardInformationDto.class);

        ResponseDto responseDto = new ResponseDto();
        ResponseCardDto responseCardDto = new ResponseCardDto();
        CardBalanceDto cardBalance = getCardBalance(cardNumber);

        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            responseCardDto.setUserName("");
            responseCardDto.setUserLastName("");
            responseCardDto.setBalance(cardBalance.getBalance());
            responseCardDto.setVirtualBalance(cardBalance.getVirtualBalance());
            responseDto.setData(responseCardDto);
            responseDto.setMessage("Balance");
        } else if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            responseDto.setData(response.getBody());
            responseDto.setMessage("error");
        } else {
            responseCardDto.setUserLastName(response.getBody().getUserLastName());
            responseCardDto.setUserName(response.getBody().getUserName());
            responseCardDto.setBalance(cardBalance.getBalance());
            responseCardDto.setVirtualBalance(cardBalance.getVirtualBalance());
            responseDto.setData(responseCardDto);
        }

        return responseDto;
    }

    private CardBalanceDto getCardBalance(String cardNumber) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(new PropertiesConnection().get("bearer.token"));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = new PropertiesConnection().get("path.url") + new PropertiesConnection().get("get.balance") + cardNumber;
        ResponseEntity<CardBalanceDto> response = restTemplate.exchange(url, HttpMethod.GET, entity, CardBalanceDto.class);

        return response.getBody();
    }
}
