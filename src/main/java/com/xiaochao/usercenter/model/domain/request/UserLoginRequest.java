package com.xiaochao.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author 超
 * @Date 2023/3/17 12:58
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -472222674176674541L;
    private String userAccount;
    private String userPassword;

}
