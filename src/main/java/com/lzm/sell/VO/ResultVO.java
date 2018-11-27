package com.lzm.sell.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 最外层返回对象
 * @ClassName ResultVO
 * @Author LZM
 * @Date 2018/11/25 10:54
 * @Version 1.0
 **/
@Data
public class ResultVO<T> {
    /*错误码*/
    private Integer code;
    /*提示信息*/
    private String msg;
    /*具体内容*/
    private T data;
}
