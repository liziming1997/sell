package com.lzm.sell.utils;

import java.util.Random;

/**
 * @ClassName KeyUtil
 * @Author LZM
 * @Date 2018/11/25 16:35
 * @Version 1.0
 **/
public class KeyUtil {

    /*
    * 生成唯一的主键
    * 需同步操作，防止多线程冲突
    * 格式：时间+随机数
    * */
    public static synchronized String genUniqueKey(){
        Random random = new Random();

        Integer a = random.nextInt(1000000);

        return System.currentTimeMillis()+String.valueOf(a);
    }
}
