package com.imovie.modules.service.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class VersionDto {

    private Long id;
    private String title;/*更新标题*/
    private String content;/*更新内容*/
    private int versionCode;/*版本号*/
    private String versionName;/*版本名称*/
    private String downloadUrl;/*下载地址*/
    private Boolean enabled;/*是否启用*/
    private Boolean forceUpdate;/*是否强制更新 0-非强制，1-强制*/
    private Timestamp CreateTime;/*创建时间*/
    private Timestamp updateTime;/*更新时间*/
}
