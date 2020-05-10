package com.lxd.controller;

import com.lxd.entity.ResultVO;
import com.lxd.entity.UserBO;
import com.lxd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;

/**
 * UserController
 *
 * @author lxd
 * @date 2020/5/10
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("hello")
    public String hellWorld() {

        return "helloWorld";
    }

    @GetMapping("byZero")
    public String byZero() {
        int a = 10/0;
        System.out.println(a);

        return "helloWorld";
    }

    @GetMapping("nullPointer")
    public String nullPointer() {

        String a = null;
        System.out.println(a.length());

        return "helloWorld";
    }


    @GetMapping("/getUser")
    public ResultVO<UserBO> getUser() {
        UserBO user = new UserBO();
        user.setId(1L);
        user.setAccount("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");

        return new ResultVO<UserBO>(user);
    }

    // 这里使用postman来测试
    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid UserBO user) {
        // 如果有参数校验失败，会将错误信息封装成对象组装在BindingResult里
//        for (ObjectError error : bindingResult.getAllErrors()) {
//            return error.getDefaultMessage();
//        }
        return userService.addUser(user);
    }

}
