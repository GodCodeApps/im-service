package com.im.service.result;
/**
 * Copyright (C), 2020-2021, 中传互动（湖北）信息技术有限公司
 *
 * @Author: pym
 * @Date: 2021/12/28:16:46
 * @Description:
 */
public enum ResultEnum {
    REQUEST_SUCCESS(1, "success"),
    REQUEST_ERROR(3, "error"),
    REQUEST_TOKEN_EXPIRED(2, "tokenExpired");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
