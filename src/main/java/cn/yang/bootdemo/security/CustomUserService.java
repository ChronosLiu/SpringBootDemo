package cn.yang.bootdemo.security;

import cn.yang.bootdemo.dao.SysUserDao;
import cn.yang.bootdemo.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Author: liuyang
 * @Description:
 * @Date: Created in 9:20 2018/2/28
 */

public class CustomUserService implements UserDetailsService {
    @Autowired
    SysUserDao sysUserDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser = this.sysUserDao.findByUsername(s);

        return sysUser;
    }
}
