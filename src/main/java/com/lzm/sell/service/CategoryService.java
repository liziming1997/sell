package com.lzm.sell.service;

import com.lzm.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @Author LZM
 * @Date 2018/11/24 16:58
 **/
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
