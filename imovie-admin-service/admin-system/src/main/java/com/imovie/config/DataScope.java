package com.imovie.config;

import com.imovie.modules.system.service.RoleService;
import com.imovie.modules.system.service.UserService;
import org.springframework.stereotype.Component;

/**
 * 数据权限配置
 *
 * @author Zheng Jie
 * @date 2019-4-1
 */
@Component
public class DataScope {

    private final String[] scopeType = {"全部", "本级", "自定义"};

    private final UserService userService;

    private final RoleService roleService;

    public DataScope(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
}
