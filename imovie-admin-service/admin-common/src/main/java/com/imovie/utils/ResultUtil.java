package com.imovie.utils;

import org.springframework.data.domain.Page;

import javax.validation.constraints.Null;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResultUtil {

    private final static String CODE = "code";
    private final static String DATA = "data";
    private final static String TOTAL = "total";
    private final static String MSG = "msg";

    public static Map<String, Object> put(Object object) {
        return put(ResultStatus.SUCCESS, object, ResultStatus.SUCCESS.getMsg());
    }

    public static Map<String, Object> put(Object object, String msg) {
        return put(ResultStatus.SUCCESS, object, msg);
    }

    public static Map<String, Object> put(ResultStatus resultStatus, String msg) {
        return put(resultStatus, null, msg);
    }

    public static Map<String, Object> put(ResultStatus resultStatus, @Null Object object, String msg) {
        Map<String, Object> map = new LinkedHashMap<>(3);
        map.put(CODE, resultStatus.getCode());
        map.put(DATA, object);
        map.put(MSG, msg == null || "".equals(msg) ? resultStatus.getMsg() : msg);
        return map;
    }

    public static Map<String, Object> putPage(ResultStatus resultStatus, Page page, String msg) {
        Map<String, Object> map = new LinkedHashMap<>(4);
        map.put(CODE, resultStatus.getCode());
        map.put(DATA, page.getContent());
        map.put(TOTAL, page.getTotalElements());
        map.put(MSG, msg == null || "".equals(msg) ? resultStatus.getMsg() : msg);
        return map;
    }

    public static Map<String, Object> put(ResultStatus resultStatus, Object object, Object totalElements, String msg) {
        Map<String, Object> map = new LinkedHashMap<>(4);
        map.put(CODE, resultStatus.getCode());
        map.put(DATA, object);
        map.put(TOTAL, totalElements);
        map.put(MSG, msg == null || "".equals(msg) ? resultStatus.getMsg() : msg);
        return map;
    }


}
