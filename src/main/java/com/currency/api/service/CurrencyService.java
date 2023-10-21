package com.currency.api.service;

import com.currency.api.domain.models.Currency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyService {


    String apiUrl = "https://cbu.uz/oz/arkhiv-kursov-valyut/json/all/" + LocalDate.now() + "/";
    Currency[] currencies = new RestTemplate().getForObject(apiUrl, Currency[].class);


}
