package com.primeton.spring.repository;

import com.primeton.spring.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wtq
 * @date 2019/8/4 - 13:21
 */

//继承我们的jpa接口，其中有很多预设法方法，我们暂时不进行自定义
@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {}
