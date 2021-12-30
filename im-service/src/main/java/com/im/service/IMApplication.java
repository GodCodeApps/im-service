package com.im.service;

import com.im.service.netty.NettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

/**
 * Copyright (C), 2020-2021, 中传互动（湖北）信息技术有限公司
 *
 * @Author: pym
 * @Date: 2021/12/28:16:46
 * @Description:
 */
@SpringBootApplication()
@MapperScan(basePackages = {"com.im.service.dao.mapper"})
public class IMApplication {
    public static void main(String[] args) {
        SpringApplication.run(IMApplication.class, args);
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(new InetSocketAddress("192.168.0.71", 8090));
    }
}
