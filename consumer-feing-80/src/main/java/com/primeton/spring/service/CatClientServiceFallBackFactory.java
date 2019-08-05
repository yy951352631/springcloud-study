package com.primeton.spring.service;

import com.primeton.spring.entities.Cat;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author Wtq
 * @date 2019/8/4 - 20:20
 */
@Component
public class CatClientServiceFallBackFactory implements FallbackFactory<CatServiceOnClient> {
    @Override
    public CatServiceOnClient create(Throwable throwable) {
        return new CatServiceOnClient() {

            @Override
            public List<Cat> getCatList() {
                return null;
            }

            @Override
            public Optional<Cat> getById(Long cat_id) {
                Cat cat = new Cat();
                cat.setCat_name("服务异常，请稍后重试");
                return Optional.of(cat);
            }

            @Override
            public Cat add(Cat cat) {
                return null;
            }

            @Override
            public void deleteById(Long cat_id) {
            }

            @Override
            public Cat update(Cat cat) {
                return null;
            }
        };
    }
}