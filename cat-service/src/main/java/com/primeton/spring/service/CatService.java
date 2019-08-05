package com.primeton.spring.service;

import com.primeton.spring.entities.Cat;

import java.util.List;
import java.util.Optional;

/**
 * @author Wtq
 * @date 2019/8/4 - 13:24
 */
/*
增删改查
 */
public interface CatService {
    public List<Cat> findAll();
    public Optional<Cat> getById(Long cat_id);
    public Cat add(Cat cat);
    public void delete(Long cat_id);
    public Cat updata(Cat cat) ;
}
