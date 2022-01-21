package com.imovie.modules.service.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class FeedbackDto {

    private Long id;
    private Long userId;/*反馈用户id*/
    private String content;/*反馈内容*/
    private String version;/*当前版本*/
    private String model;/*机型*/
    private String mobile;/*联系手机*/
    private String email;/*联系邮箱*/
    private Timestamp createTime;
    private Timestamp updateTime;
}
