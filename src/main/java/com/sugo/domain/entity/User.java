package com.sugo.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by sugo on 2018/12/9.
 */

@Data
public class User {
    /**
     * 用户id
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String faceImage;

    /**
     * 随机salt值
     */
    private String salt;

    /**
     * 用户角色
     */
    private String role;

    /**
     * 设备id
     */
    private String cid;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
