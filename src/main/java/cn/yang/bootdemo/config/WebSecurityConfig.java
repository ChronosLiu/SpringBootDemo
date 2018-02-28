package cn.yang.bootdemo.config;

import cn.yang.bootdemo.security.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 扩展sping security配置
 * @Author: liuyang
 * @Description:
 * @Date: Created in 9:25 2018/2/28
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 注册自定义的customUserService的bean
     * @return
     */
    @Bean
    UserDetailsService customUserService(){
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //添加自定义的customUserService认证
        auth.userDetailsService(customUserService());
    }

    /**
     * 请求拦截
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()   //所有请求需认证登录才可访问
                .and()
                .formLogin()                    //定制登录行为
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .permitAll()    //可任意访问
                .and()
                .logout().permitAll();      //定制注销行为，注销页面可任意访问
    }
}
