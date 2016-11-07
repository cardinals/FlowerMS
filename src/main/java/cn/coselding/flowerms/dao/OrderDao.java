package cn.coselding.flowerms.dao;

import cn.coselding.flowerms.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
public interface OrderDao {
    int insert(Order order);
    int delete(int orderID);
    int update(Order order);
    Order queryById(int orderID);

    List<Order> queryPage(@Param("startindex") int startindex, @Param("pagesize")int pagesize);
    int queryCount();
    int searchOrdersCount(@Param("orderID") int orderID, @Param("sendMan")String sendMan, @Param("startTime")Date startTime,@Param("endTime") Date endTime,@Param("saleman") int saleman);
    List<Order> searchOrdersPage(@Param("orderID")int orderID, @Param("sendMan")String sendMan, @Param("startTime")Date startTime, @Param("endTime")Date endTime, @Param("saleman")int saleman,@Param("startindex") int startindex, @Param("pagesize")int pagesize);

    List<Integer> queryCustomerCountByName(@Param("customerName")String customerName);
    List<Order> queryCustomerPageByName(@Param("customerName")String customerName,@Param("startindex") int startindex, @Param("pagesize")int pagesize);
    List<Integer> queryCustomerCount();
    List<Order> queryCustomerPage(@Param("startindex") int startindex, @Param("pagesize")int pagesize);
    List<Order> queryCustomerAll();
    int deleteCustomer(String sendName);
}
