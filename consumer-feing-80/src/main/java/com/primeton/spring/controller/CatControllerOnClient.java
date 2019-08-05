package com.primeton.spring.controller;

import com.primeton.spring.entities.Cat;
import com.primeton.spring.service.CatServiceOnClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Wtq
 * @date 2019/8/4 - 17:35
 */
@RestController
@RequestMapping(value = "/consumer")
public class CatControllerOnClient {
    @Autowired
    private CatServiceOnClient service;

    @GetMapping
    public List<Cat> getCatList() {
        return service.getCatList();
    }

    @GetMapping(value = "/{cat_id}")
    public Optional<Cat> getById(@PathVariable("cat_id") Long cat_id) {
        return service.getById(cat_id);
    }

    @PostMapping
    public Cat add(@RequestBody Cat cat) {
        return service.add(cat);
    }

    @DeleteMapping(value = "/{cat_id}")
    public void deleteById(@PathVariable("cat_id") Long cat_id) {
    }

    @PutMapping
    public Cat update(@RequestBody Cat cat) {
        return service.update(cat);
    }
}
