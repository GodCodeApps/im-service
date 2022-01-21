package com.imovie.modules.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "t_app_version")
public class Version implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;/*更新标题*/
    private String content;/*更新内容*/
    @Column(name = "version_code")
    private int versionCode;/*版本号*/
    @Column(name = "version_name")
    private String versionName;/*版本名称*/
    @Column(name = "download_url")
    private String downloadUrl;/*下载地址*/
    private Boolean enabled;/*是否启用 0-启用，1-禁用*/
    @Column(name = "force_update")
    private Boolean forceUpdate;/*是否强制更新 0-非强制，1-强制*/
    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp CreateTime;/*创建时间*/
    @Column(name = "update_time")
    @UpdateTimestamp
    private Timestamp updateTime;/*更新时间*/
}
