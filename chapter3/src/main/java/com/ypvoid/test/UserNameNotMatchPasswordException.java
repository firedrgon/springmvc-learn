package com.ypvoid.test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Yuanping on 2017/12/8.
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户名和密码不匹配!")
public class UserNameNotMatchPasswordException extends RuntimeException {
    private static final long serialVersionUID = 1L;
}
