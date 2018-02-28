package cn.yang.bootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: liuyang
 * @Description:
 * @Date: Created in 9:23 2018/2/28
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //注册访问/login转向login.html页面
        registry.addViewController("/login").setViewName("login");
      //  super.addViewControllers(registry);
    }
}
