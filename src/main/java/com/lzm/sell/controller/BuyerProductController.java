package com.lzm.sell.controller;

import com.lzm.sell.VO.ProductInfoVO;
import com.lzm.sell.VO.ProductVO;
import com.lzm.sell.VO.ResultVO;
import com.lzm.sell.dataobject.ProductCategory;
import com.lzm.sell.dataobject.ProductInfo;
import com.lzm.sell.service.CategoryService;
import com.lzm.sell.service.ProductService;
import com.lzm.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 买家看到的商品
 * @ClassName BuyerProductController
 * @Author LZM
 * @Date 2018/11/25 10:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    private ResultVO list(){
        /*查询所有上架的商品*/
        List<ProductInfo> productInfoList = productService.findUpAll();

        /*查询类目*/
        List<Integer> categoryTypeList = new ArrayList<>();
        categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);


        /*数据拼装*/
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory:productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOlist(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
