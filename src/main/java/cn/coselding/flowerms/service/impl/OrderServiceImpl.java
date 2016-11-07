package cn.coselding.flowerms.service.impl;

import cn.coselding.flowerms.dao.OrderDao;
import cn.coselding.flowerms.dto.Page;
import cn.coselding.flowerms.model.Order;
import cn.coselding.flowerms.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by 宇强 on 2016/7/14 0014.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public int addOrder(Order order) {
        return orderDao.insert(order);
    }

    @Transactional
    @Override
    public int updateOrder(Order order) {
        Order tmp = orderDao.queryById(order.getOrderID());
        tmp.setQuantity(order.getQuantity());
        tmp.setSalesman(order.getSalesman());
        tmp.setStatus(order.getStatus());
        tmp.setSendName(order.getSendName());
        tmp.setReceiveTel(order.getReceiveTel());
        tmp.setReceiveAdd(order.getReceiveAdd());
        tmp.setReceiveName(order.getReceiveName());
        tmp.setRemarks(order.getRemarks());
        tmp.setFlowerID(order.getFlowerID());
        tmp.setSendTime(order.getSendTime());
        tmp.setSendState(order.getSendState());
        tmp.setPayState(order.getPayState());
        return orderDao.update(tmp);
    }

    @Override
    public int deleteOrder(int orderID) {
        return orderDao.delete(orderID);
    }

    @Override
    public Order queryById(int orderID) {
        return orderDao.queryById(orderID);
    }

    @Transactional
    @Override
    public Page<Order> getPage(String pagenum, String url) {
        // 总记录数
        int totalrecord = orderDao.queryCount();
        Page<Order> page = null;
        if (pagenum == null)
            // 没传递页号，回传第一页数据
            page = new Page<Order>(totalrecord, 1);
        else
            // 根据传递的页号查找所需显示数据
            page = new Page<Order>(totalrecord, Integer.parseInt(pagenum));
        List<Order> list = orderDao.queryPage(page.getStartindex(),page.getPagesize());
        page.setList(list);
        page.setUrl(url);
        return page;
    }

    @Transactional
    @Override
    public Page<Order> searchOrders(int orderID, String sendMan, Date startTime, Date endTime, int saleman,String pagenum,String url) {
        // 总记录数
        int totalrecord = orderDao.searchOrdersCount(orderID,sendMan,startTime,endTime,saleman);
        Page<Order> page = null;
        if (pagenum == null)
            // 没传递页号，回传第一页数据
            page = new Page<Order>(totalrecord, 1);
        else
            // 根据传递的页号查找所需显示数据
            page = new Page<Order>(totalrecord, Integer.parseInt(pagenum));
        List<Order> list = orderDao.searchOrdersPage(orderID,sendMan,startTime,endTime,saleman,page.getStartindex(),page.getPagesize());
        page.setList(list);
        page.setUrl(url);
        return page;
    }

    @Transactional
    @Override
    public Page<Order> queryCustomer(String pagenum, String url) {
        // 总记录数
        int totalrecord = orderDao.queryCustomerCount().size();
        Page<Order> page = null;
        if (pagenum == null)
            // 没传递页号，回传第一页数据
            page = new Page<Order>(totalrecord, 1);
        else
            // 根据传递的页号查找所需显示数据
            page = new Page<Order>(totalrecord, Integer.parseInt(pagenum));
        List<Order> list = orderDao.queryCustomerPage(page.getStartindex(),page.getPagesize());
        page.setList(list);
        page.setUrl(url);
        return page;
    }

    @Override
    public List<Order> listCustomers() {
        return orderDao.queryCustomerAll();
    }

    @Transactional
    @Override
    public Page<Order> queryCustomerByName(String customerName, String pagenum, String url) {
        // 总记录数
        int totalrecord = orderDao.queryCustomerCountByName(customerName).size();
        Page<Order> page = null;
        if (pagenum == null)
            // 没传递页号，回传第一页数据
            page = new Page<Order>(totalrecord, 1);
        else
            // 根据传递的页号查找所需显示数据
            page = new Page<Order>(totalrecord, Integer.parseInt(pagenum));
        List<Order> list = orderDao.queryCustomerPageByName(customerName,page.getStartindex(),page.getPagesize());
        page.setList(list);
        page.setUrl(url);
        return page;
    }

    @Override
    public int deleteCustomer(String sendName) {
        return orderDao.deleteCustomer(sendName);
    }
}
