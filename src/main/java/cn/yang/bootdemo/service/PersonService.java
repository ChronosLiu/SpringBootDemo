package cn.yang.bootdemo.service;

import cn.yang.bootdemo.domain.Person;

/**
 * @Author: liuyang
 * @Description:
 * @Date: Created in 12:24 2018/2/26
 */

public interface PersonService {
    /**
     * 保存person，事务回滚
     * @param person
     * @return
     */
    Person savePersonWithRollBack(Person person);

    /**
     * 保存person,事务不回滚
     * @param person
     * @return
     */
    Person savePersonWithoutRollBack(Person person);

    /**
     * 保存
     * @param person
     * @return
     */
    Person save(Person person);

    /**
     * 删除
     * @param id
     */
    void remove(Long id);

    /**
     * 查询一个
     * @param person
     * @return
     */
    Person findOne(Person person);

}
