package cn.yang.bootdemo.service.impl;

import cn.yang.bootdemo.mapper.UserMapper;
import cn.yang.bootdemo.model.User;
import cn.yang.bootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return this.userMapper.selectUserById(id);
    }

}
