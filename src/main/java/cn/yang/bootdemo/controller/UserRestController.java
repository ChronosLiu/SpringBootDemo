package cn.yang.bootdemo.controller;

import cn.yang.bootdemo.model.User;
import cn.yang.bootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private User user;

    @Value("${user1.name}")
    @RequestMapping(value = "/getUserById")
    public User getUserById(){
        return this.userService.getUserById(1);
    }
    @RequestMapping(value = "/")
    public String getUser(){
     //   User user = new User();
        return user.getUserName()+user.getPassWord();
    }

}
