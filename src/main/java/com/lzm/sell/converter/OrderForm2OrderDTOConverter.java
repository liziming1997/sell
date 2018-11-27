package com.lzm.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzm.sell.dataobject.OrderDetail;
import com.lzm.sell.dto.OrderDTO;
import com.lzm.sell.enume.ResultEnum;
import com.lzm.sell.exception.SellException;
import com.lzm.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderForm2OrderDTOConverter
 * @Author LZM
 * @Date 2018/11/26 11:22
 * @Version 1.0
 **/
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson =new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList =new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("【对象转换】错误，string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetails(orderDetailList);
        return orderDTO;

    }
}
