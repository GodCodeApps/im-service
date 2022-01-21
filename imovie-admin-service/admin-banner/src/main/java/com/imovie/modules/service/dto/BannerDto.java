package com.imovie.modules.service.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BannerDto {
    private Long id;
    private String title;/*标题*/
    private String bannerUrl;/*图片地址*/
    private int type;/*banner类型 0-movie、1-tv、2-animation、3-ad*/
    private Boolean enabled;/*启用状态 0-启用，1-禁用*/
    private Timestamp createTime;/*创建时间*/
    private Timestamp updateTime;/*更新时间*/
}
