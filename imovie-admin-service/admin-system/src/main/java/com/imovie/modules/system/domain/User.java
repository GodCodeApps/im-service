package com.imovie.modules.system.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * @author Zheng Jie
 * @date 2018-11-22
 */
@Entity
@Data
@Table(name = "t_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = Update.class)
    private Long id;

    /*用户名*/
    @NotBlank
    @Column(unique = true)
    private String username;

    /*用户昵称*/
    @NotBlank
    private String nickName;

    /*性别 0-男，1-女*/
    private int gender;

    /*用户类型 0-普通用户，1-管理员，2-会员*/
    @Column(name = "user_type")
    private int userType;

    /*会员开通时间*/
    @Column(name = "member_start_time")
    private Timestamp memberStartTime;

    /*会员结束时间*/
    @Column(name = "member_end_time")
    private Timestamp memberEndTime;

    /*头像id*/
    @OneToOne
    @JoinColumn(name = "avatar_id")
    private UserAvatar userAvatar;

    /*邮箱*/
    @NotBlank
    @Email
    private String email;

    /*手机号*/
    @NotBlank
    private String phone;

    /*是否启用*/
    @NotNull
    private Boolean enabled;

    /*密码*/
    private String password;

    /*创建时间*/
    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;

    /*最后修改密码时间*/
    @Column(name = "last_password_reset_time")
    private Date lastPasswordResetTime;

    /*用户角色类型*/
    @ManyToMany
    @JoinTable(name = "t_users_roles", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;

    /*最后登录时间*/
    @Column(name = "last_login_time")
    private Timestamp lastLoginTime;

    /*设备标识*/
    private String device;

    public @interface Update {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}