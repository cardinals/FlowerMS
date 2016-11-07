package cn.coselding.flowerms.service;

import cn.coselding.flowerms.dto.Page;
import cn.coselding.flowerms.model.Order;

import java.util.Date;
import java.util.List;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
public interface OrderService {

    int addOrder(Order order);
    int updateOrder(Order order);
    int deleteOrder(int orderID);
    Order queryById(int orderID);
    Page<Order> getPage(String pagenum,String url);
    Page<Order> searchOrders(int orderID, String sendMan, Date startTime, Date endTime, int saleman,String pagenum,String url);

    Page<Order> queryCustomer(String pagenum,String url);
    List<Order> listCustomers();
    Page<Order> queryCustomerByName(String customerName,String pagenum,String url);
    int deleteCustomer(String orderID);
}
