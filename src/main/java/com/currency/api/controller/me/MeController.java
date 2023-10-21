package com.currency.api.controller.me;


import com.currency.api.domain.response.SingleResponse;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;



@RestController
@RequestMapping("/")
@Tag(name = "Me Controller", description = "the MeController Api")
public class MeController {

    @Operation(
            summary = "Example api",
            description = "get all data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping
    public ResponseEntity<?> getMain(){
        SingleResponse singleResponse = new SingleResponse(true,"unsuccess", HttpStatus.OK);
        return ResponseEntity.status(singleResponse.getHttpStatus()).body(singleResponse);

    }

    @Hidden
    @GetMapping("/error")
    public ResponseEntity<?> handleError(){
        SingleResponse singleResponse = new SingleResponse(false,"unsuccess", HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(singleResponse.getHttpStatus()).body(singleResponse);

    }

}
