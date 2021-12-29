package com.im.service.service.impl;

import com.im.service.dao.entity.Message;
import com.im.service.dao.mapper.MessageMapper;
import com.im.service.service.IMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (C), 2020-2021, 中传互动（湖北）信息技术有限公司
 *
 * @Author: pym
 * @Date: 2021/12/28:16:46
 * @Description:
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

    @Override
    public List<Message> queryList() {
        return baseMapper.queryList();
    }
}
