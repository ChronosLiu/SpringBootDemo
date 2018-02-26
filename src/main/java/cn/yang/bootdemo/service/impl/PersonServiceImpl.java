package cn.yang.bootdemo.service.impl;

import cn.yang.bootdemo.dao.PersonRepository;
import cn.yang.bootdemo.domain.Person;
import cn.yang.bootdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: liuyang
 * @Description:
 * @Date: Created in 12:26 2018/2/26
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithRollBack(Person person) {
        Person p = this.personRepository.save(person);
        if (person.getName().equals("aa")){
            throw new IllegalArgumentException("数据存在，回滚");
        }
        return p;
    }
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithoutRollBack(Person person) {
        Person p = this.personRepository.save(person);
        if (person.getName().equals("aa")){
            throw new IllegalArgumentException("数据存在，但不会回滚");
        }
        return p;
    }

    @Override
    @CachePut(value = "people",key = "#person.id")
    public Person save(Person person) {
        Person p = this.personRepository.save(person);
        System.out.println("id为"+p.getId()+"数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = "people")
    public void remove(Long id) {
        System.out.println("删除id为"+id+"的缓存数据");
      //  this.personRepository.delete(id);
    }

    @Override
    @Cacheable(value = "people",key = "#person.id")
    public Person findOne(Person person) {
        Person p = this.personRepository.findOne(person.getId());
        System.out.println("id为"+p.getId()+"数据做了缓存");
        return p;
    }
}
