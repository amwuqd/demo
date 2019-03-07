package com.example.web;


import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping(value = "/users")
public class HelloController {

    static  Map<String,Person> persons = Collections.synchronizedMap(new HashMap<String, Person>());
    static  Map<String,Person> personMap = new ConcurrentHashMap<String, Person>();

    @Autowired
    private Student student;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Person> getPersonLists(){
        List<Person> personList = new ArrayList<Person>(persons.values());
        return personList;
    }
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Person postPerson(@RequestBody Person person){
        System.out.println("personcode"+person.getPersonCode());
        persons.put(person.getPersonCode(),person);
        personMap.put(person.getPersonCode(),person);
        System.out.println(persons.get(person.getPersonCode()).toString());
        System.out.println(personMap.get(person.getPersonCode()));
//        return persons.get(person.getPersonCode());
        return persons.get(person.getPersonCode());
    }
    @RequestMapping(value = "/getPersonByPersonCode",method = RequestMethod.POST)
    public Person getPersonByPersonCode(@RequestBody Person person){
        System.out.println("personcode:"+person.getPersonCode());
        return persons.get(person.getPersonCode());
    }

    @GetMapping(value = "/hello",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Map<String,Object> hello(){
        Map<String,Object> map = new HashMap<>();
        map.put("id","1111");
        map.put("time", new Date());
        return map;
    }
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


    @GetMapping(value = "/student")
    public Student student(){
        return student;
    }
    @RequestMapping(value = "createUser",method = RequestMethod.POST)
    public String createUser(String name, int age){
        System.out.println("name:"+name);
        System.out.println("age:"+age);
        userService.createUser(name,age);
        return "insert user ok";

    }


}
