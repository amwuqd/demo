package com.example.Service;

import com.example.web.Person;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;


@Mapper
public interface PersonMapper {
    @Select("select * from person where personcode=#{personcode}")
    Person findByPeroncode(@Param("personcode") String personcode);



    @Insert("INSERT INTO `person` (`personcode`, `username`, `sex`, `birthday`,`createtime`) " +
            "VALUES (#{personcode}, #{username}, #{sex}, #{birthday}, #{createtime})")
    int insertIntoPerson(@Param("personcode") String personcode, @Param("username") String username, @Param("sex") String sex,
                         @Param("birthday") String birthday,  @Param("createtime") Date createtime);

    @Insert("INSERT INTO `person` (`personcode`, `username`, `sex`, `birthday`,`createtime`) " +
            "VALUES (#{personCode}, #{Username}, #{sex}, #{birthday}, #{createTime})")
    int insertIntoPersonE(Person person);
//
//    @Results({
//            @Result(property = "personCode", column = "personcode"),
//            @Result(property = "Username", column = "username")
//    })
    @Select({
            "<script>",
            "select personcode,username from person where personcode in",
            "<foreach collection='personCodeList' item='personcode' open='(' separator=',' close=')'>",
            "#{personcode}",
            "</foreach>",
            "</script>"
    })
    List<Person> findPersonByPersoncodeList(@Param("personCodeList") List<String> personCodeList);

    @Select("select * from person")
    List<Person> findPersonAll();
}

