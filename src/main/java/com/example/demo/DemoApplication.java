package com.example.demo;

import com.example.web.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan("com.example")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET},value = "/demo")
	public Person demo(){
		Person person = new Person();
		person.setPersonCode("00116271");
		person.setUsername("黄奖");
		person.setBirthday("1900-02-02");
		person.setSex("male");
		return person;
	}

}
