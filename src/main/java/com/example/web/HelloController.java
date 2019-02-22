package com.example.web;


import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {


    @GetMapping(value = "/hello",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Map<String,Object> hello(){
        Map<String,Object> map = new HashMap<>();
        map.put("id","1111");
        map.put("time", new Date());
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/person")
    public Person person(HttpServletRequest request){
        Person person = new Person();
        person.setPersonCode("00116271");
        person.setUsername("Huangjiang");
        person.setSex("male");
        person.setBirthday("1990-01-01");
        person.setCreateTime(new Date());
        return  person;
    }
    @RequestMapping(value = "/person1")
    public Person person1(HttpServletRequest request){
        Person person1 = new Person();
        person1.setPersonCode("00116271");
        person1.setUsername("Huangjiang");
        person1.setSex("male");
        person1.setBirthday("1990-01-01");
        person1.setCreateTime(new Date());
        return  person1;
    }

    @RequestMapping(value = "/person3")
    public Person person3(HttpServletRequest request){
        Person person1 = new Person();
        person1.setPersonCode("00116271");
        person1.setUsername("Huangjiang");
        person1.setSex("male");
        person1.setBirthday("1990-01-01");
        person1.setCreateTime(new Date());
        return  person1;
    }
    @RequestMapping(value = "/person4")
    public Person person4(HttpServletRequest request){
        Person person1 = new Person();
        person1.setPersonCode("00116271");
        person1.setUsername("Huangjiang");
        person1.setSex("male");
        person1.setBirthday("1990-01-01");
        person1.setCreateTime(new Date());
        return  person1;
    }

    @RequestMapping(value = "/person5")
    public Person person5(HttpServletRequest request){
        Person person1 = new Person();
        person1.setPersonCode("00116271");
        person1.setUsername("黄奖");
        person1.setSex("male");
        person1.setBirthday("1990-01-01");
        person1.setCreateTime(new Date());
        return  person1;
    }


}
