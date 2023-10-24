package com.currency.api.service;

import com.currency.api.domain.models.Currency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyService {

    private final RestTemplate restTemplate;

    public List<Currency>  getAllCurrencyList(){

        String apiUrl = "https://cbu.uz/oz/arkhiv-kursov-valyut/json/all/" + LocalDate.now() + "/";
        Currency[] currencies = restTemplate.getForObject(apiUrl, Currency[].class);

        List<Currency> currencyList = new ArrayList<>();
        if (currencies != null && currencies.length > 0){
            currencyList.addAll(List.of(currencies));
        }
        return currencyList;

    }

    public List<Currency>  getCurrencyListById(String id){

        String apiUrl = "https://cbu.uz/oz/arkhiv-kursov-valyut/json/all/" + LocalDate.now() + "/";
        Currency[] currencies = restTemplate.getForObject(apiUrl, Currency[].class);

        List<Currency> currencyList = new ArrayList<>();
        if (currencies != null && currencies.length > 0){
            Arrays.stream(currencies).forEachOrdered(currency -> {
                if (currency.getCode().equals(id) || String.valueOf(currency.getCode()) == id){
                    currencyList.add(currency);
                }
            });
        }
        return currencyList;

    }




}
