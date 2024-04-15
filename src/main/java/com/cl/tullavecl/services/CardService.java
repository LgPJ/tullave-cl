package com.cl.tullavecl.services;

import com.cl.tullavecl.Dtos.CardBalanceDto;
import com.cl.tullavecl.Dtos.CardInformationDto;
import com.cl.tullavecl.Dtos.ResponseCardDto;
import com.cl.tullavecl.Dtos.ResponseDto;
import com.cl.tullavecl.utils.PropertiesConnection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
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
        ResponseEntity<CardInformationDto> response = null;
        try {
            response = restTemplate.exchange(url, HttpMethod.GET, entity, CardInformationDto.class);
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                CardBalanceDto cardBalance = getCardBalance(cardNumber);
                ResponseCardDto responseCardDto = new ResponseCardDto();
                responseCardDto.setUserName("");
                responseCardDto.setUserLastName("");
                responseCardDto.setBalance(cardBalance.getBalance());
                responseCardDto.setVirtualBalance(cardBalance.getVirtualBalance());
                ResponseDto responseDto = new ResponseDto();
                responseDto.setData(responseCardDto);
                responseDto.setMessage("Balance");
                return responseDto;
            } else if (ex.getStatusCode() == HttpStatus.BAD_REQUEST) {
                ResponseDto responseDto = getResponseError(ex);
                return responseDto;
            } else if (ex.getStatusCode() == HttpStatus.CONFLICT) {
                ResponseDto responseDto = getResponseError(ex);
                return responseDto;

            }
        }

        CardBalanceDto cardBalance = getCardBalance(cardNumber);
        ResponseCardDto responseCardDto = new ResponseCardDto();
        responseCardDto.setUserLastName(response.getBody().getUserLastName());
        responseCardDto.setUserName(response.getBody().getUserName());
        responseCardDto.setBalance(cardBalance.getBalance());
        responseCardDto.setVirtualBalance(cardBalance.getVirtualBalance());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(responseCardDto);
        responseDto.setMessage("Balance");
        return responseDto;
    }

    private ResponseDto getResponseError(HttpClientErrorException ex) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode errorNode = objectMapper.readTree(ex.getResponseBodyAsString());
        String errorCode = errorNode.get("errorCode").asText();
        String errorMessage = errorNode.get("errorMessage").asText();
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(errorCode +" "+ errorMessage);
        responseDto.setMessage("error");
        return responseDto;
    }

    private CardBalanceDto getCardBalance(String cardNumber) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(new PropertiesConnection().get("bearer.token"));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = new PropertiesConnection().get("path.url") + new PropertiesConnection().get("get.balance") + cardNumber;
        ResponseEntity<CardBalanceDto> response = null;
        try {
            response = restTemplate.exchange(url, HttpMethod.GET, entity, CardBalanceDto.class);
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.SERVICE_UNAVAILABLE) {
                throw new IOException("Service Unavailable");
            } else if (ex.getStatusCode() == HttpStatus.CONFLICT) {
                throw new IOException("Conflict");
            } else {
                throw ex;
            }
        }

        return response.getBody();
    }
}
