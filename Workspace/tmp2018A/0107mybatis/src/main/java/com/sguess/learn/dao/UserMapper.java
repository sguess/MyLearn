package com.sguess.learn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sguess.learn.bean.User;

@Mapper
public interface UserMapper {
    @Insert("insert into user(name,age) values(#{name},#{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertUser(User user);

    @Insert("delete from  user")
    int deleteAll();


    //	@Results(value= {
//			@Result(property="")
//	})
    @Select("select * from user where age=#{age}")
    User selectOneUserByAge(int age);

    @Select("select * from user where name like #{name}")
    List<User> selectUserListLikeName(String name);

    @Select("select name,age from user")
    Map<String, Integer> selectUserMap();

    @Update("update user set age= #{newAge} where name like #{name}")
    int updateAgeByName(@Param("name") String name, @Param("newAge") int age);
}
