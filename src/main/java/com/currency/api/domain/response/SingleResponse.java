package com.currency.api.domain.response;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.io.Serializable;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class SingleResponse implements Serializable {

    static final long serialVersionUID = 42L;

    private boolean success;
    private String message;
    private Object data;
    private List<Object> dataList;
    private Map<String, Object> meta = new HashMap<>();
    private HttpStatus httpStatus;


    public SingleResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
        if (success) {
            httpStatus = HttpStatus.OK;
        }
    }

    public SingleResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        if (data instanceof List) {
            this.dataList = (List) data;
        } else if (data instanceof Set) {
            this.dataList = new LinkedList<>((Set) data);
        } else {
            this.data = data;
        }
        if (success) {
            httpStatus = HttpStatus.OK;
        }
    }

    public SingleResponse(boolean success, String message, List<Object> dataList) {
        this.success = success;
        this.message = message;
        this.dataList = dataList;
        if (success) {
            httpStatus = HttpStatus.OK;
        }
    }

    public SingleResponse(boolean success, Map<String, Object> meta) {
        this.success = success;
        this.meta = meta;
        if (success) {
            httpStatus = HttpStatus.OK;
        }
    }

    public SingleResponse(boolean success, String message, HttpStatus httpStatus) {
        this.success = success;
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
