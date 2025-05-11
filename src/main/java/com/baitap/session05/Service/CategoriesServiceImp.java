package com.baitap.session05.Service;

import com.baitap.session05.Dao.CategoriesDao;
import com.baitap.session05.Dao.CategoriesDaoImp;
import com.baitap.session05.Modal.Categories;

import java.util.List;

public class CategoriesServiceImp implements CategoriesService {
    private final CategoriesDao categoriesDAO;
    public CategoriesServiceImp() {
        categoriesDAO = new CategoriesDaoImp();
    }
    @Override
    public List<Categories> findAll() {
        return categoriesDAO.findAll();
    }
    @Override
    public boolean save(Categories catalog) {
        return categoriesDAO.save(catalog);
    }
}
