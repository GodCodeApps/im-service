package com.imovie.modules.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author admin
* @date 2020-03-29
*/
@Data
public class AgreementDto implements Serializable {

    private Long id;

    /** 协议标题 */
    private String title;

    /** 协议内容 */
    private String content;

    /** 协议类型 0-用户协议，1-隐私政策 */
    private Integer type;

    /** 创建时间 */
    private Timestamp createTime;

    /** 更新时间 */
    private Timestamp updateTime;
}