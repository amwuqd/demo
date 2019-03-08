package com.example.Service;

import com.example.web.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.Date;


@Mapper
public interface PersonMapper {
    @Select("select * from person where personcode=#{personcode}")
    Person findByPeroncode(@Param("personcode") String personcode);

    @Insert("INSERT INTO `person` (`personcode`, `username`, `sex`, `birthday`,`createtime`) " +
            "VALUES (#{personcode}, #{username}, #{sex}, #{birthday}, #{createtime})")
    int insertIntoPerson(@Param("personcode") String personcode, @Param("username") String username, @Param("sex") String sex,
                         @Param("birthday") String birthday,  @Param("createtime") Date createtime);
}

