package cn.yang.bootdemo.dao;

import cn.yang.bootdemo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: liuyang
 * @Description:
 * @Date: Created in 12:19 2018/2/25
 */

public interface PersonRepository extends JpaRepository<Person,Long> {
    List<Person> findByName(String name);
    Person findByNameAndAddress(String name,String address);
    @Query("select p from Person  p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name") String name,
                                   @Param("address") String address);

    List<Person> withNameAndAddressNameQuery( String name, String address);

}
