package com.lzm.sell.dataobject;

import com.lzm.sell.enume.OrderStatusEnum;
import com.lzm.sell.enume.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName OrderMaster
 * @Author LZM
 * @Date 2018/11/25 15:01
 * @Version 1.0
 **/
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /*订单id*/
    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /*支付状态，默认未支付0*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /*创建时间*/
    private Date createTime;

    /*更新时间*/
    private Date updateTime;

}
