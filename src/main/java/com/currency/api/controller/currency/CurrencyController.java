package com.currency.api.controller.currency;

import com.currency.api.domain.response.SingleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

@RestController
@RequestMapping("/currency")
@Slf4j
@Tag(name = "Currency", description = "the currency Api")
public class CurrencyController {


    @Operation(
            summary = "Example api",
            description = "get all data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/all")
    public ResponseEntity<?> getMain(){
        SingleResponse singleResponse = new SingleResponse(
                true,
                "currency",
                "currency api",
                Collections.singletonList(
                        new ArrayList<String>(Arrays.asList("USD", "UZS", "RUBL"))),
                new HashMap<>(),
                HttpStatus.OK);
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
    @GetMapping("/active/{id}")
    public ResponseEntity<?> getActiveCurrency(@PathVariable("id")String id){

        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

       return  ResponseEntity.status(HttpStatus.OK).body(new Object());
    }

}
