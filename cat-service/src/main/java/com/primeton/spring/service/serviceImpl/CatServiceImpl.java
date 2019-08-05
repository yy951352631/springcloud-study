package com.primeton.spring.service.serviceImpl;

import com.primeton.spring.entities.Cat;
import com.primeton.spring.repository.CatRepository;
import com.primeton.spring.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Wtq
 * @date 2019/8/4 - 13:25
 */
@Service
public class CatServiceImpl implements CatService {
    @Autowired
    private CatRepository catRepository;

    @Override
    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    @Override
    public Optional<Cat> getById(Long cat_id) {
        return catRepository.findById(cat_id);
    }

    @Override
    public Cat add(Cat cat) {
        return catRepository.save(cat);
    }

    @Override
    public void delete(Long cat_id) {
        catRepository.deleteById(cat_id);
    }

    @Override
    public Cat updata(Cat cat) {
        return catRepository.save(cat);
    }
}
