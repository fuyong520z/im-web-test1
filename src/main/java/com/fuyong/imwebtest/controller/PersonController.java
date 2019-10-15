package com.fuyong.imwebtest.controller;


import com.fuyong.imwebtest.configp.HelloSender;
import com.fuyong.imwebtest.pojo.Person;
import com.fuyong.imwebtest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @Autowired
    private HelloSender helloSender;


    @RequestMapping("/queryLimtOne")
    @ResponseBody
    public Person queryLimtOne() {

        this.helloSender.send(personService.queryLimtOne());
        return personService.queryLimtOne();
    }
}
