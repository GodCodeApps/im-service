package com.im.service.result;

import lombok.Data;
/**
 * Copyright (C), 2020-2021, 中传互动（湖北）信息技术有限公司
 *
 * @Author: pym
 * @Date: 2021/12/28:16:46
 * @Description:
 */
@Data
public class ResponseVO<T> {

    private String msg;

    private Integer code;

    private T data;

    private ResponseVO() {
    }

    public static <T> ResponseVO success() {
        ResponseVO<T> responseVO = new ResponseVO<>();
        responseVO.setCode(ResultEnum.REQUEST_SUCCESS.getCode());
        responseVO.setMsg(ResultEnum.REQUEST_SUCCESS.getMsg());
        return responseVO;
    }

    public static <T> ResponseVO success(T data) {
        ResponseVO<T> responseVO = new ResponseVO<>();
        responseVO.setCode(ResultEnum.REQUEST_SUCCESS.getCode());
        responseVO.setMsg(ResultEnum.REQUEST_SUCCESS.getMsg());
        responseVO.setData(data);
        return responseVO;
    }

    public static <T> ResponseVO success(String msg) {
        ResponseVO<T> responseVO = new ResponseVO<>();
        responseVO.setCode(ResultEnum.REQUEST_SUCCESS.getCode());
        responseVO.setMsg(msg);
        return responseVO;
    }

    public static <T> ResponseVO error() {
        ResponseVO<T> responseVO = new ResponseVO<>();
        responseVO.setCode(ResultEnum.REQUEST_ERROR.getCode());
        responseVO.setMsg(ResultEnum.REQUEST_ERROR.getMsg());
        return responseVO;
    }

    public static <T> ResponseVO error(String msg) {
        ResponseVO<T> responseVO = new ResponseVO<>();
        responseVO.setCode(ResultEnum.REQUEST_ERROR.getCode());
        responseVO.setMsg(msg);
        return responseVO;
    }

    public static <T> ResponseVO error(ResultEnum resultEnum, String msg) {
        ResponseVO<T> responseVO = new ResponseVO<>();
        responseVO.setCode(resultEnum.getCode());
        responseVO.setMsg(msg);
        return responseVO;
    }
}
