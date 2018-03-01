package cn.yang.bootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 扩展MVC
 * @Author: liuyang
 * @Description:
 * @Date: Created in 9:23 2018/2/28
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 自定义页面跳转控制
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //注册访问/login转向login.html页面
        registry.addViewController("/login").setViewName("login");
        super.addViewControllers(registry);
    }

    /**
     * 自定义静态资源映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //方式：addResourceHandler 指定映射url,addResourceLocation指定路径
        //registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/");
        super.addResourceHandlers(registry);
    }

    /**
     * 自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addINterceptor添加自定义的拦截器 ，实现HandlerInterceptor 接口
        //addPathPatterns 添加拦截规则
        //execludePathPatterns 排除拦截，例外情况
       // registry.addInterceptor(1).addPathPatterns("/**").excludePathPatterns("/toLogin","/login");
        super.addInterceptors(registry);
    }
}
