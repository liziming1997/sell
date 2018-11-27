package com.lzm.sell.enume;

import lombok.Getter;

/**
 * @ClassName OrderStatusEnum
 * @Author LZM
 * @Date 2018/11/25 15:05
 * @Version 1.0
 **/
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消")
    ;
    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
