package com.im.service.service;

import com.im.service.dao.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Copyright (C), 2020-2021, 中传互动（湖北）信息技术有限公司
 *
 * @Author: pym
 * @Date: 2021/12/28:16:46
 * @Description:
 */
public interface IMessageService extends IService<Message> {
    List<Message> queryList();
}
