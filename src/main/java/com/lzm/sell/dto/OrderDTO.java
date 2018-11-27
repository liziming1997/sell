package com.lzm.sell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lzm.sell.dataobject.OrderDetail;
import com.lzm.sell.enume.OrderStatusEnum;
import com.lzm.sell.enume.PayStatusEnum;
import com.lzm.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderDTO
 * @Author LZM
 * @Date 2018/11/25 16:08
 * @Version 1.0
 **/
@Data
public class OrderDTO {
    /*订单id*/
    private String orderId;
    /*买家姓名*/
    private String buyerName;
    /*买家手机号*/
    private String buyerPhone;
    /*买家地址*/
    private String buyerAddress;
    /*买家微信Openid*/
    private String buyerOpenid;
    /*订单总金额*/
    private BigDecimal orderAmount;
    /*订单状态，默认新下单*/
    private Integer orderStatus ;

    /*支付状态，默认未支付0*/
    private Integer payStatus ;

    /*创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /*更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetails;

}
