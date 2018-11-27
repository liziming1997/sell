package com.lzm.sell.service;

import com.lzm.sell.dto.OrderDTO;

/**
 * @Author LZM
 * @Date 2018/11/26 16:53
 **/
public interface BuyerService {

    //更新一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
