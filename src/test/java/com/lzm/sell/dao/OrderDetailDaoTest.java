package com.lzm.sell.dao;

import com.lzm.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void saveOrderDetailTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123455126");
        orderDetail.setOrderId("1111233");
        orderDetail.setProductIcon("htp");
        orderDetail.setProductId("1123465");
        orderDetail.setProductName("鸡脚");
        orderDetail.setProductPrice(new BigDecimal(3.2));
        orderDetail.setProductQuantity(3);

        OrderDetail result = orderDetailDao.save(orderDetail);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByOrderId() {
        List<OrderDetail> result = orderDetailDao.findByOrderId("1111233");
        Assert.assertNotEquals(0,result.size());
    }
}