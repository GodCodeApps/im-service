package com.imovie.modules.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "t_banner")
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;/*标题*/
    @Column(name = "banner_url")
    private String bannerUrl;/*图片地址*/
    private int type;/*banner类型 0-movie、1-tv、2-animation、3-ad*/
    private Boolean enabled;/*启用状态 0-启用，1-禁用*/
    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;/*创建时间*/
    @Column(name = "update_time")
    @UpdateTimestamp
    private Timestamp updateTime;/*更新时间*/
}
