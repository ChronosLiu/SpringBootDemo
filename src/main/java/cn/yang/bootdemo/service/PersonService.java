package cn.yang.bootdemo.service;

import cn.yang.bootdemo.domain.Person;

/**
 * @Author: liuyang
 * @Description:
 * @Date: Created in 12:24 2018/2/26
 */

public interface PersonService {
    Person savePersonWithRollBack(Person person);
    Person savePersonWithoutRollBack(Person person);
}
