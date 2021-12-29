package com.im.service.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
/**
 * Copyright (C), 2020-2021, 中传互动（湖北）信息技术有限公司
 *
 * @Author: pym
 * @Date: 2021/12/28:16:46
 * @Description:
 */
public class Message extends Model<Message> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 消息id
     */
    private String messageId;

    /**
     * 会话类型
     */
    private Integer sessionType;

    /**
     * 会话id
     */
    private String sessionId;

    /**
     * 消息类型
     */
    private Integer type;

    /**
     * 消息方向
     */
    private Integer direct;

    /**
     * 发送状态
     */
    private Integer status;

    /**
     * 发送时间
     */
    private LocalDateTime time;

    /**
     * 消息体
     */
    private String attachment;

    /**
     * 扩展字段
     */
    private String extra;

    /**
     * 发送者昵称
     */
    private String nickName;

    /**
     * 发送者id
     */
    private String account;

    /**
     * 发送者头像
     */
    private String avatar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Integer getSessionType() {
        return sessionType;
    }

    public void setSessionType(Integer sessionType) {
        this.sessionType = sessionType;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDirect() {
        return direct;
    }

    public void setDirect(Integer direct) {
        this.direct = direct;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "Message{" +
        ", id=" + id +
        ", messageId=" + messageId +
        ", sessionType=" + sessionType +
        ", sessionId=" + sessionId +
        ", type=" + type +
        ", direct=" + direct +
        ", status=" + status +
        ", time=" + time +
        ", attachment=" + attachment +
        ", extra=" + extra +
        ", nickName=" + nickName +
        ", account=" + account +
        ", avatar=" + avatar +
        "}";
    }
}
