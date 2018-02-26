package cn.yang.bootdemo.controller;

import cn.yang.bootdemo.dao.PersonRedisDao;
import cn.yang.bootdemo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用redis
 * @Author: liuyang
 * @Description:
 * @Date: Created in 17:50 2018/2/26
 */
@RestController
@RequestMapping("/redis")
public class PersonRedisConroller {
    @Autowired
    PersonRedisDao personRedisDao;

    /**
     * 保存
     * save 使用RedisTemplate
     * saveStr 使用StringRedisTemplate
     */
    @RequestMapping("/set")
    public void set(){
        Person person = new Person(1L,"aa","'bb",1);
        this.personRedisDao.save(person);
        this.personRedisDao.saveStr();
    }

    /**
     * 获取字符串 通过StringRedisTemplate
     * @return
     */
    @RequestMapping("/getStr")
    public String getStr(){
        return this.personRedisDao.getString();
    }

    /**
     * 获取对象，通过RedisTemplate
     * @param id
     * @return
     */
    @RequestMapping("/getP")
    public Person getPerson(Long id){
        return this.personRedisDao.getPerson(id);
    }
}
