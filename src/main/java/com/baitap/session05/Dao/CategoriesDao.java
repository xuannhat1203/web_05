package com.baitap.session05.Dao;

import com.baitap.session05.Modal.Categories;

import java.util.List;

public interface CategoriesDao {
    List<Categories> findAll();
    boolean save(Categories catalog);
}
