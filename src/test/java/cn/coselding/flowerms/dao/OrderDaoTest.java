package cn.coselding.flowerms.dao;

import cn.coselding.flowerms.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class OrderDaoTest {

    @Resource
    private OrderDao orderDao;

    @Test
    public void testInsert() throws Exception {
        Order order = new Order();
        order.setFlowerID(34);
        order.setStatus((short)1);
        order.setRemarks("备注2");
        order.setOrderDate(new Date());
        order.setPayState((short)0);
        order.setQuantity(300);
        order.setReceiveAdd("美国");
        order.setReceiveName("JAck");
        order.setReceiveTel("11111111111");
        order.setSalesman(105);
        order.setSendName("Coselding");
        order.setSendState((short)3);
        order.setSendTime(new Date(System.currentTimeMillis()+100000000));
        orderDao.insert(order);
    }

    @Test
    public void testDelete() throws Exception {
        orderDao.delete(2);
    }

    @Test
    public void testUpdate() throws Exception {
        Order order = new Order();
        order.setFlowerID(34);
        order.setStatus((short)1);
        order.setRemarks("备注");
        order.setOrderDate(new Date());
        order.setPayState((short)0);
        order.setQuantity(300);
        order.setReceiveAdd("美国");
        order.setReceiveName("Jack");
        order.setReceiveTel("11111111111");
        order.setSalesman(105);
        order.setSendName("Coselding");
        order.setSendState((short)3);
        order.setSendTime(new Date(System.currentTimeMillis()+100000000));
        order.setOrderID(1);
        orderDao.update(order);
    }

    @Test
    public void testQueryById() throws Exception {
        System.out.println(orderDao.queryById(1));
    }

    @Test
    public void testQueryPage() throws Exception {
        System.out.println(orderDao.queryPage(1,2));
    }

    @Test
    public void testQueryCount() throws Exception {
        System.out.println(orderDao.queryCount());
    }
}