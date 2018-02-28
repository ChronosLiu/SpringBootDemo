package cn.yang.bootdemo.dao;

import cn.yang.bootdemo.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: liuyang
 * @Description:
 * @Date: Created in 9:17 2018/2/28
 */

public interface SysUserDao extends JpaRepository<SysUser,Long> {
    SysUser findByUsername(String username);
}
