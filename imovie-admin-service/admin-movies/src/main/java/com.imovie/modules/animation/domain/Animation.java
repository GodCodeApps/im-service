package com.imovie.modules.animation.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author admin
* @date 2020-03-30
*/
@Entity
@Data
@Table(name="t_animation")
public class Animation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** 片名 */
    @Column(name = "title",nullable = false)
    @NotBlank
    private String title;

    /** 别名 */
    @Column(name = "alias")
    private String alias;

    /** 语言 */
    @Column(name = "language")
    private String language;

    /** 封面图 */
    @Column(name = "cover")
    private String cover;

    /** 评分 */
    @Column(name = "rating")
    private String rating;

    /** 年份 */
    @Column(name = "year")
    private String year;

    /** 导演 */
    @Column(name = "director")
    private String director;

    /** 编剧 */
    @Column(name = "writer")
    private String writer;

    /** 主演 */
    @Column(name = "actors")
    private String actors;

    /** 类型 */
    @Column(name = "type")
    private String type;

    /** 集数 */
    @Column(name = "count")
    private String count;

    /** 上映日期 */
    @Column(name = "release_date")
    private String releaseDate;

    /** 上映地区 */
    @Column(name = "area")
    private String area;

    /** 单集时长 */
    @Column(name = "duration")
    private String duration;

    /** 简介 */
    @Column(name = "introduction")
    private String introduction;

    /** 预告片 */
    @Column(name = "trailer")
    private String trailer;

    /** 是否热门 0-普通，1-热门 */
    @Column(name = "hot")
    private Boolean hot;

    /** 是否最新 0-普通，1-最新 */
    @Column(name = "latest")
    private Boolean latest;

    /** 创建时间 */
    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

    /** 更新时间 */
    @UpdateTimestamp
    @Column(name = "update_time")
    private Timestamp updateTime;

    public void copy(Animation source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}