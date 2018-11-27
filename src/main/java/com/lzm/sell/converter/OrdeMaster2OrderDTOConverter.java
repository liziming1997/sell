package com.lzm.sell.converter;

import com.lzm.sell.dataobject.OrderMaster;
import com.lzm.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName OrdeMaster2OrderDTOConverter
 * @Author LZM
 * @Date 2018/11/26 9:40
 * @Version 1.0
 **/
public class OrdeMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO =new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e ->convert(e)).collect(Collectors.toList());
    }

}
