package com.primeton.spring.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.primeton.spring.entities.Cat;
import com.primeton.spring.service.serviceImpl.CatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Wtq
 * @date 2019/8/4 - 13:20
 */
@RestController
@RequestMapping(value = "/cats")
public class CatController {
    @Autowired
    private CatServiceImpl serviceImpl;

    @GetMapping
    public List<Cat> getCatList() {
        return serviceImpl.findAll();
    }

    @PostMapping
    public Cat add(@RequestBody Cat cat) {
        return serviceImpl.add(cat);
    }

    @DeleteMapping(value = "/{cat_id}")
    public void deleteById(@PathVariable("cat_id") Long cat_id) {
    }

    @PutMapping
    public Cat update(@RequestBody Cat cat) {
        return serviceImpl.updata(cat);
    }

    @GetMapping(value = "/{cat_id}")
    //定义我们的服务熔断方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Optional<Cat> getById(@PathVariable("cat_id") Long cat_id) {
        Optional<Cat> cat = serviceImpl.getById(cat_id);
        if (!cat.isPresent()) {
            throw new RuntimeException("该ID" + cat_id + "没有对应信息");
        }
        return cat;
    }

    public Optional<Cat> processHystrix_Get(@PathVariable("cat_id") Long cat_id) {
        Cat errorObj = new Cat();
        errorObj.setCat_name("该ID" + cat_id + "不存在，请尝试其他id");
        errorObj.setCat_age(999);
        errorObj.setCatType("错误页面");
        Optional<Cat> opCat = Optional.of(errorObj);
        return opCat;
    }
}
