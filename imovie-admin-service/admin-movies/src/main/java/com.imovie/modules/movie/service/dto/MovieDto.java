package com.imovie.modules.movie.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class MovieDto implements Serializable {

    private Long id;
    private String title;
    private String alias;
    private String cover;
    private double rating;
    private int year;
    private String area;/*地区*/
    private String language;/*语言*/
    private String director;
    private String writer;
    private String actors;
    private String type;
    private String releaseDate;
    private String duration;
    private String introduction;
    private String trailer;
    private int ranking;/*豆瓣排名*/
    private Boolean hot;/*是否热门电影 0-非热门，1-热门*/
    private Boolean latest;/*是否最新电影 0-非最新，1-最新*/
    private Timestamp createTime;/*创建时间*/
    private Timestamp updateTime;/*更新更新*/
}
