package cn.yang.bootdemo.controller;

import cn.yang.bootdemo.dao.PersonRepository;
import cn.yang.bootdemo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * JPA使用
 * @Author: liuyang
 * @Description:
 * @Date: Created in 12:33 2018/2/25
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    /**
     * 保存 save 支持批量保存
     * @param name
     * @param address
     * @param age
     * @return
     */
    @RequestMapping("/save")
    public Person save(String name,String address,Integer age){
        Person p = this.personRepository.save(new Person(null,name,address,age));
        return p;
    }

    /**
     * 删除 delete 通过id删除，支持批量删除
     * @param id
     */
    @RequestMapping("/delete")
    public void delete(Long id){
        this.personRepository.delete(id);
    }

    @RequestMapping("/q1")
    public List<Person> findByName(String name){
        List<Person> people = this.personRepository.findByName(name);
        return people;
    }
    @RequestMapping("/q2")
    public Person findByNameAndAddress(String name,String address){
        Person p = this.personRepository.findByNameAndAddress(name,address);
        return p;
    }

    /**
     * Query注解
     * @param name
     * @param address
     * @return
     */
    @RequestMapping("/q3")
    public Person withNameAndAddressQuery(String name, String address){
        Person p = this.personRepository.withNameAndAddressQuery(name, address);
        return p;
    }

    /**
     * NameQuery注解
     * @param name
     * @param address
     * @return
     */
    @RequestMapping("/q4")
    public List<Person> withNameAndAddressNameQuery( String name, String address){
        List<Person> people = this.personRepository.withNameAndAddressNameQuery(name, address);
        return people;
    }

    /**
     * 排序 sort
     * @return
     */
    @RequestMapping("/sort")
    public List<Person> sort(){
        List<Person> people = this.personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
        return people;
    }

    /**
     * 分页 page
     * @return
     */
    @RequestMapping("/page")
    public Page<Person> page(){
        Page<Person> people = this.personRepository.findAll(new PageRequest(1,2));
        return people;
    }


}
