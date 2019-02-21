package com.example.web;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {


    @GetMapping(value = "/hello",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Map<String,Object> hello(){
        Map<String,Object> map = new HashMap<>();
        map.put("id","1111");
        map.put("time",new Date());
        return map;
    }



}
