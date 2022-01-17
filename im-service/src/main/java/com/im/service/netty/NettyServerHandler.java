package com.im.service.netty;

import com.alibaba.fastjson.JSON;
import com.im.service.dao.entity.Message;
import com.im.service.service.impl.MessageServiceImpl;
import com.im.service.utils.ApplicationContextUtil;
import io.netty.channel.*;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright (C), 2020-2021, 中传互动（湖北）信息技术有限公司
 *
 * @Author: pym
 * @Date: 2021/12/29:16:01
 * @Description:
 */
@Service
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    private static Map<String, ChannelHandlerContext> map = new HashMap<>();
    private final ConcurrentHashMap<String, Channel> channelMap = new ConcurrentHashMap<>();
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
//        AttributeKey<Object> objectAttributeKey = AttributeKey.valueOf("user_id");
//        String o = (String) ctx.channel().attr(objectAttributeKey).get();

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        String string = msg.toString();
        Message message = JSON.parseObject(string, Message.class);
        MessageServiceImpl service = ApplicationContextUtil.getBean(MessageServiceImpl.class);
        service.saveOrUpdate(message);
        Channel channel = ctx.channel();
        ChannelId id = channel.id();
        System.out.println("id" + id);
        map.put(id.toString(), ctx);
        System.out.println("channelRead" + string);
        map.forEach((k, v) -> {
            if (id.toString().equals(k)) {
                v.writeAndFlush(string);
            } else {
                message.setDirect(1);
                v.writeAndFlush(JSON.toJSONString(message));
            }
            System.out.println("服务器回复消息" + string);
        });
    }
}
