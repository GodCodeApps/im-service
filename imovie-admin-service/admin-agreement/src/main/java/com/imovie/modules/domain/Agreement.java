package com.imovie.modules.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author admin
* @date 2020-03-29
*/
@Entity
@Data
@Table(name="t_agreement")
public class Agreement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** 协议标题 */
    @Column(name = "title",nullable = false)
    @NotBlank
    private String title;

    /** 协议内容 */
    @Column(name = "content",nullable = false)
    @NotBlank
    private String content;

    /** 协议类型 0-用户协议，1-隐私政策 */
    @Column(name = "type")
    private Integer type;

    /** 创建时间 */
    @Column(name = "create_time")
    private Timestamp createTime;

    /** 更新时间 */
    @Column(name = "update_time")
    private Timestamp updateTime;

    public void copy(Agreement source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}