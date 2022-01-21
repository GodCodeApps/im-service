package com.imovie.modules.variety.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author admin
* @date 2020-03-30
*/
@Data
public class VarietyDto implements Serializable {

    private Long id;

    /** 片名 */
    private String title;

    /** 别名 */
    private String alias;

    /** 语言 */
    private String language;

    /** 封面图 */
    private String cover;

    /** 评分 */
    private String rating;

    /** 年份 */
    private String year;

    /** 导演 */
    private String director;

    /** 编剧 */
    private String writer;

    /** 主演 */
    private String actors;

    /** 类型 */
    private String type;

    /** 集数 */
    private String count;

    /** 上映日期 */
    private String releaseDate;

    /** 上映地区 */
    private String area;

    /** 单集时长 */
    private String duration;

    /** 简介 */
    private String introduction;

    /** 预告片 */
    private String trailer;

    /** 是否热门 0-普通，1-热门 */
    private Boolean hot;

    /** 是否最新 0-普通，1-最新 */
    private Boolean latest;

    /** 创建时间 */
    private Timestamp createTime;

    /** 更新时间 */
    private Timestamp updateTime;
}