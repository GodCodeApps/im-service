package com.imovie.utils;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 分页工具
 *
 * @author Zheng Jie
 * @date 2018-12-10
 */
public class PageUtil extends cn.hutool.core.util.PageUtil {

    /**
     * List 分页
     */
    public static List toPage(int page, int size, List list) {
        int fromIndex = page * size;
        int toIndex = page * size + size;
        if (fromIndex > list.size()) {
            return new ArrayList();
        } else if (toIndex >= list.size()) {
            return list.subList(fromIndex, list.size());
        } else {
            return list.subList(fromIndex, toIndex);
        }
    }

    /**
     * Page 数据处理，预防redis反序列化报错
     */
    public static Map<String, Object> toPage(Page page) {
        return toPage(ResultStatus.SUCCESS, page, ResultStatus.SUCCESS.getMsg());
    }

    public static Map<String, Object> toPage(ResultStatus resultStatus, Page page, String msg) {
        return ResultUtil.putPage(resultStatus, page, msg);
    }

    /**
     * 自定义分页
     */
    public static Map<String, Object> toPage(Object object, Object totalElements) {
        return toPage(ResultStatus.SUCCESS, object, totalElements, ResultStatus.SUCCESS.getMsg());
    }

    public static Map<String, Object> toPage(ResultStatus resultStatus, Object object, Object totalElements, String msg) {
        return ResultUtil.put(resultStatus, object, totalElements, msg);
    }

}
