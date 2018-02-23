package cn.yang.bootdemo.mapper;

import cn.yang.bootdemo.model.User;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserMapper {

   // @Select("select * from user where id = #{id}")
    User selectUserById(int id);
}
