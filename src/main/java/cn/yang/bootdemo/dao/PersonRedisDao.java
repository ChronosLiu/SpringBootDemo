package cn.yang.bootdemo.dao;

import cn.yang.bootdemo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Person dao层，采用redis数据库
 * @Author: liuyang
 * @Description:
 * @Date: Created in 17:38 2018/2/26
 */
@Repository
public class PersonRedisDao {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String,String> valOpsStr;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    @Resource(name="redisTemplate")
    ValueOperations<Object,Object> valOps;

    public void saveStr(){
        this.valOpsStr.set("aa","bb");
    }

    public void save(Person person){
        valOps.set(Long.toString(person.getId()),person);
    }

    public String getString(){
        return valOpsStr.get("aa");
    }
    public Person getPerson(Long id){
        return (Person) valOps.get(Long.toString(id));
    }
}
