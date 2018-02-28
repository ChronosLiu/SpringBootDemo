package cn.yang.bootdemo.controller;

import cn.yang.bootdemo.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: liuyang
 * @Description:
 * @Date: Created in 18:04 2018/2/28
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model){
        Msg msg = new Msg("测试标题","测试内容","额外内容，对管理员展示");
        model.addAttribute("msg",msg);
        return "home";
    }
}
