package com.imovie.modules.movie.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "t_movie")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = Update.class)
    private Long id;
    private String title;/*电影名称*/
    private String alias;/*别名*/
    private String cover;/*封面海报*/
    private double rating;/*豆瓣评分*/
    private int year;/*年份*/
    private String area;/*地区*/
    private String language;/*语言*/
    private String director;/*导演*/
    private String writer;/*编剧*/
    private String actors;/*主演*/
    private String type;/*类型*/

    @Column(name = "release_date")
    private String releaseDate;/*上映日期*/
    private String duration;/*时长*/
    private String introduction;/*介绍*/
    private String trailer;/*预告片地址*/
    private int ranking;/*豆瓣排名*/
    private Boolean hot = false;/*是否热门电影 0-非热门，1-热门*/
    private Boolean latest = false;/*是否最新电影 0-非最新，1-最新*/
    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;/*创建时间*/
    @Column(name = "update_time")
    @UpdateTimestamp
    private Timestamp updateTime;/*更新更新*/

    public @interface Update {
    }
}
