package com.lzm.sell.utils;

import com.lzm.sell.VO.ResultVO;

/**
 * @ClassName ResultVOUtil
 * @Author LZM
 * @Date 2018/11/25 12:10
 * @Version 1.0
 **/
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}
