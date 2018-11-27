package com.lzm.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lzm.sell.dataobject.ProductInfo;
import lombok.Data;

import java.util.List;

/**
 * 商品包含类目
 * @ClassName ProductVO
 * @Author LZM
 * @Date 2018/11/25 11:25
 * @Version 1.0
 **/
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOlist;
}
