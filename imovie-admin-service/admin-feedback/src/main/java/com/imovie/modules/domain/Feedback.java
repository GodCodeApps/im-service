package com.imovie.modules.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "t_feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;/*反馈用户id*/
    private String content;/*反馈内容*/
    private String version;/*当前版本*/
    private String model;/*机型*/
    private String mobile;/*联系手机*/
    private String email;/*联系邮箱*/

    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;
    @Column(name = "update_time")
    @UpdateTimestamp
    private Timestamp updateTime;


}
