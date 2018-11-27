package com.lzm.sell.service.impl;

import com.lzm.sell.dataobject.OrderDetail;
import com.lzm.sell.dto.OrderDTO;
import com.lzm.sell.enume.OrderStatusEnum;
import com.lzm.sell.enume.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private  OrderServiceImpl orderService;

    private final String BUYER_OPENID = "123456";

    private final String ORDER_ID = "1543195132023264277";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("黎子明");
        orderDTO.setBuyerAddress("佛冈");
        orderDTO.setBuyerPhone("13420122011");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("12342");
        o1.setProductQuantity(2);

        OrderDetail o12 = new OrderDetail();
        o12.setProductId("456");
        o12.setProductQuantity(2);
        orderDetailList.add(o1);
        orderDetailList.add(o12);
        orderDTO.setOrderDetails(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);

        log.info("【创建订单】 result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO one = orderService.findOne(ORDER_ID);
        Assert.assertNotNull(one);
    }

    @Test
    public void findList() {
        PageRequest request= new PageRequest(0,2);

        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, request);

        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO one = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(one);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());

    }

    @Test
    public void finish() {
        OrderDTO one = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(one);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());

    }

    @Test
    public void paid() {
        OrderDTO one = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(one);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());

    }
}