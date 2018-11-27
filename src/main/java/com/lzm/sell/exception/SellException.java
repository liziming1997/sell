package com.lzm.sell.exception;

import com.lzm.sell.enume.ResultEnum;

/**
 * @ClassName SellException
 * @Author LZM
 * @Date 2018/11/25 16:23
 * @Version 1.0
 **/
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellException( Integer code,String message) {
        super(message);
        this.code = code;
    }
}
