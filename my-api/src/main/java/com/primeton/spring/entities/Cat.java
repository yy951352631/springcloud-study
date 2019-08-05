package com.primeton.spring.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Wtq
 * @date 2019/8/4 - 13:18
 */
@Entity
@Data
public class Cat {
    @Id
    @GeneratedValue
    private Long cat_id;
    private String cat_name;
    private int cat_age;
    private String catType;

    public Long getCat_id() {
        return cat_id;
    }

    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public int getCat_age() {
        return cat_age;
    }

    public void setCat_age(int cat_age) {
        this.cat_age = cat_age;
    }

    public String getCatType() {
        return catType;
    }

    public void setCatType(String catType) {
        this.catType = catType;
    }
}
