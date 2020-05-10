package com.lxd.service;

import com.lxd.entity.UserBO;

/**
 * UserService
 *
 * @author lxd
 * @date 2020/5/10
 **/
public interface UserService {

    /**
     * 添加用户
     * @param user 用户对象
     * @return 成功则返回"success"，失败则返回错误信息
     */
    String addUser(UserBO user);
}
