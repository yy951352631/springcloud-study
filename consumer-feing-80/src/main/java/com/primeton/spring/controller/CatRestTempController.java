package com.primeton.spring.controller;

import com.primeton.spring.entities.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Wtq
 * @date 2019/8/4 - 17:58
 */
@RestController
@RequestMapping(value="/consumer")
public class CatRestTempController {
    private static final String REST_URL_PREFIX = "http://MY-CAT-MANAGER";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/get/{id}")
    public Cat get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/cats/"+id,Cat.class);
    }
    @RequestMapping(value="/list")
    public List<Cat> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/cats",List.class);
    }
}
