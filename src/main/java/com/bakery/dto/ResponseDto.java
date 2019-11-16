package com.bakery.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Behrooz Mohamadi
 * @email behroooz.mohamadi@gmail.com
 * @date 3/27/2018 11:42 AM
 */

public class ResponseDto {

    private HttpStatus status;
    private Object data;
    private String error;

    public ResponseDto() {
        this(null);
    }

    public ResponseDto(Object data) {
        this.data = data;
        this.error = null;
    }

    public ResponseEntity send() {
        this.status = HttpStatus.OK;
        return new ResponseEntity(this, status);
    }

    public ResponseEntity send(String error) {
        this.status = HttpStatus.OK;
        this.error = error;
        return new ResponseEntity(this, status);
    }

    public Object getData() {
        return data;
    }

    public String getError() {
        return error;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}