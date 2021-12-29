package com.im.service.controller;


import com.im.service.result.ResponseVO;
import com.im.service.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2020-2021, 中传互动（湖北）信息技术有限公司
 *
 * @Author: pym
 * @Date: 2021/12/28:16:46
 * @Description:
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageServiceImpl messageService;

    @RequestMapping("/list")
    public ResponseVO find() {
        return ResponseVO.success(messageService.queryList());
    }
}
