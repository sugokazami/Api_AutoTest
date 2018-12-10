package com.touzhijia.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by sugo on 2018/12/9.
 */

@Data
@Entity
@Table(name = "users")
public class User {
    /**
     * 用户id
     */
    @Id
    private String id ;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String userName ;

    /**
     * 用户密码
     */
    @Column(name = "password")
    private String passWord ;

    /**
     * 用户昵称
     */
    @Column(name = "nickname")
    private String nickName ;

    /**
     * 用户头像
     */
    private String faceImage ;

    /**
     * 随机salt值
     */
    private String salt ;

    /**
     * 用户角色
     */
    private String role ;

    /**
     * 设备id
     */
    private String cid ;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
