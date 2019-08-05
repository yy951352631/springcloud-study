package com.primeton.spring.service;

import com.primeton.spring.entities.Cat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

/**
 * @author Wtq
 * @date 2019/8/4 - 17:35
 */
/*
这里定义我们的feign接口，来完成与eureka的整合，其中的方法名与待调用的微服务controller层一致
 */
@Service
@FeignClient(value = "MY-CAT-MANAGER", fallbackFactory = CatClientServiceFallBackFactory.class)//这里填写我们需要调用的微服务名
@RequestMapping(value = "/cats")
public interface CatServiceOnClient {
    @GetMapping
    public List<Cat> getCatList();

    @GetMapping(value = "/{cat_id}")
    public Optional<Cat> getById(@PathVariable("cat_id") Long cat_id);

    @PostMapping
    public Cat add(@RequestBody Cat cat);

    @DeleteMapping(value = "/{cat_id}")
    public void deleteById(@PathVariable("cat_id") Long cat_id);

    @PutMapping
    public Cat update(@RequestBody Cat cat);
}
