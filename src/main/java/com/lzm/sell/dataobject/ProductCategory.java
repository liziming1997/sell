package com.lzm.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ClassName ProductCategory
 * @Author LZM
 * @Date 2018/11/24 15:40
 * @Version 1.0
 **/
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryName;

    private  Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategory() {
    }
}
