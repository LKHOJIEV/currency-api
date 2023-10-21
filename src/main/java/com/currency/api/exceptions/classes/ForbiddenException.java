package com.currency.api.exceptions.classes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@EqualsAndHashCode(callSuper = true)
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException{

    private String type;
    private String message;

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(Throwable cause, String type, String message1) {
        this.type = type;
        this.message = message1;
    }
}
