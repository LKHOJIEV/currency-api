package com.currency.api.controller.currency;

import com.currency.api.domain.models.Currency;
import com.currency.api.domain.response.SingleResponse;
import com.currency.api.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/v1/currency")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Currency", description = "the currency Api")
public class CurrencyController {

    private final CurrencyService currencyService;

    @Operation(
            summary = "Example api",
            description = "get all data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",content = {}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/all")
    public ResponseEntity<?> getMain(){

        SingleResponse singleResponse = new SingleResponse();

        List<Currency> currencyList = currencyService.getAllCurrencyList();
        if (!currencyList.isEmpty()){
            log.info(currencyList.size() +" data found");
            singleResponse = new SingleResponse(
                    true,
                    "currency",
                    currencyList.size()+" currency list",
                    Collections.singletonList(currencyList),
                    new HashMap<>(),
                    HttpStatus.OK
            );
        }else {
            log.info("currency data not found");

        }
        return ResponseEntity.status(singleResponse.getHttpStatus()).body(singleResponse);
    }

    @Operation(
            summary = "Example api",
            description = "get all data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getActiveCurrency(@PathVariable("id")String id){
        SingleResponse singleResponse = new SingleResponse();
        List<Currency> currencyList = currencyService.getCurrencyListById(id);
        if (!currencyList.isEmpty()){
            log.info(currencyList.size() +" data found by currency id: "+id);
             singleResponse = new SingleResponse(
                    true,
                    "currency",
                    "currency list by id",
                    Collections.singletonList(currencyList),
                    new HashMap<>(),
                    HttpStatus.OK
            );


        }

//        log.trace("A TRACE Message");
//        log.debug("A DEBUG Message");
//        log.info("An INFO Message");
//        log.warn("A WARN Message");
//        log.error("An ERROR Message");

        return ResponseEntity.status(singleResponse.getHttpStatus()).body(singleResponse);
    }

}
