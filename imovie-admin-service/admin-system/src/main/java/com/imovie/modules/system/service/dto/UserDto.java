package com.imovie.modules.system.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 */
@Data
public class UserDto implements Serializable {

    @ApiModelProperty(hidden = true)
    private Long id;

    private String username;

    private String nickName;

    private int gender;

    private String avatar;

    private int userType;

    private String email;

    private String phone;

    private Boolean enabled;

    @JsonIgnore
    private String password;

    private Timestamp memberStartTime;

    private Timestamp memberEndTime;

    private Date lastPasswordResetTime;

    private Timestamp lastLoginTime;

    @ApiModelProperty(hidden = true)
    private Set<RoleSmallDto> roles;

    private Timestamp createTime;

    private String device;

}
