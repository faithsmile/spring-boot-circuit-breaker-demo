package com.demo.circuitbreaker.hystrix.controller;

import com.demo.circuitbreaker.hystrix.core.component.proxy.PersonServiceProxy;
import com.demo.commons.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final PersonServiceProxy personServiceProxy;

    @Autowired
    public TestController(final PersonServiceProxy personServiceProxy) {
        this.personServiceProxy = personServiceProxy;
    }

    @PostMapping
    public String testMethod(@RequestBody final Person person) {
        return this.personServiceProxy.getPersonByName(person.getName()).getName();
    }

}
