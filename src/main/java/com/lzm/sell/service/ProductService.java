package com.lzm.sell.service;

import com.lzm.sell.dataobject.ProductInfo;
import com.lzm.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author LZM
 * @Date 2018/11/25 10:22
 **/
public interface ProductService {
    ProductInfo findOne(String prodcutId);
    /*
        查询在架的商品
     */
    List<ProductInfo> findUpAll ();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /*加库存*/
    void increaseStock(List<CartDTO> cartDTOList);

    /*减库存*/
    void decreaseStock(List<CartDTO> cartDTOList);

}
