package com.lxd.service.impl;

import com.lxd.entity.UserBO;
import com.lxd.service.UserService;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @author lxd
 * @date 2020/5/10
 **/
@Service
public class UserServiceImpl implements UserService {

    public String addUser(UserBO user) {
        // 直接编写业务逻辑
        return "success";
    }
}
