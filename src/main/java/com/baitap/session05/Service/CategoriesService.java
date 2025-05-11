package com.baitap.session05.Service;
import com.baitap.session05.Modal.Categories;
import java.util.List;
public interface CategoriesService {
    List<Categories> findAll();
    boolean save(Categories catalog);
}
