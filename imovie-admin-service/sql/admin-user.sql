# 用户加密方式变动，改为 BCryptPasswordEncoder方式： SHA-256 +随机盐+密钥对密码进行加密，替换后的明文密码为 123456
update t_user set `password` = "$2a$10$HhxyGZy.ulf3RvAwaHUGb.k.2i9PBpv4YbLMJWp8pES7pPhTyRCF." WHERE `password` = "e10adc3949ba59abbe56e057f20f883e"