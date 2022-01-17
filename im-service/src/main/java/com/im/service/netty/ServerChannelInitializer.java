package com.im.service.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.CharsetUtil;

import java.util.Map;

/**
 * Copyright (C), 2020-2021, 中传互动（湖北）信息技术有限公司
 *
 * @Author: pym
 * @Date: 2021/12/29:16:02
 * @Description:public
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
//        Attribute<Object> attr = socketChannel.read().attr(AttributeKey.valueOf("USER_ID"));
//        String userId = attr.get().toString();
//        System.out.println("initChannel"+userId);
        socketChannel.pipeline().addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
        socketChannel.pipeline().addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
        socketChannel.pipeline().addLast("handler", new NettyServerHandler());
    }
}
