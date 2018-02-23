package cn.yang.bootdemo.controller;

import cn.yang.bootdemo.model.User;
import cn.yang.bootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: liuyang
 * @Description:
 * @Date: Created in 12:55 2018/2/22
 */
@Controller
@RequestMapping("/userWeb")
public class UserWebController {
    @Autowired
    private UserService userService;

    @RequestMapping("/th")
    public String thymeleafHtml(Model model){
        User user = this.userService.getUserById(1);
        System.out.println(user.getUserName());
        model.addAttribute("user",user);
        return "index";
    }
}
