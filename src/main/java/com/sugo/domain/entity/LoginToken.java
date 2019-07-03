package com.sugo.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sugo on 2018/12/9.
 */

@Data
@Entity
@Table(name = "login_token")
public class LoginToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    /**
     * 用户id
     */
    private String userId ;

    /**
     * 过期时间
     */
    private Date expired ;

    /**
     * 状态
     */
    private Integer status ;

    /**
     * token
     */
    private String token ;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
