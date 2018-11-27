package com.lzm.sell.enume;

import lombok.Getter;

/**
 * @Author LZM
 * @Date 2018/11/25 15:08
 **/
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功")
    ;
    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
