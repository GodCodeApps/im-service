package com.imovie.utils;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@ToString
@Getter
public enum ResultStatus {

    SUCCESS(HttpStatus.OK, 0, "SUCCESS"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, 400, "Bad Request"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "Internal Server Error");

    private HttpStatus httpStatus;
    private Integer code;
    private String msg;

    ResultStatus(HttpStatus httpStatus, Integer code, String msg) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.msg = msg;
    }
}
