package cn.coselding.flowerms.web;

import cn.coselding.flowerms.dao.FlowerDao;
import cn.coselding.flowerms.dto.Page;
import cn.coselding.flowerms.model.Flower;
import cn.coselding.flowerms.model.Order;
import cn.coselding.flowerms.model.Worker;
import cn.coselding.flowerms.service.OrderService;
import cn.coselding.flowerms.service.ProductService;
import cn.coselding.flowerms.service.UserService;
import cn.coselding.flowerms.utils.Global;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    private static final long OFFSET = 10000*365*24*60*60*1000;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private OrderService orderService;

    @Resource
    private UserService userService;

    @Resource
    private ProductService productService;


    @RequestMapping(value = "/{orderID}", method = RequestMethod.GET)
    public String info(@PathVariable("orderID") int orderID,
                       Model model) {
        Order order = orderService.queryById(orderID);
        model.addAttribute("order", order);
        return "order_info";
    }

    @RequestMapping(value = "/list/{pagenum}", method = RequestMethod.GET)
    public String list(@PathVariable("pagenum") String pagenum,
                       HttpServletRequest request,
                       Model model) {
        String url = request.getContextPath()+"/order/list/";
        Page<Order> page = orderService.getPage(pagenum, url);
        model.addAttribute("page", page);

        List<Worker> workers = userService.listWorkers();
        model.addAttribute("workers", workers);
        List<Order> orders = orderService.listCustomers();
        model.addAttribute("customers", orders);
        return "order_list";
    }

    @RequestMapping(value = "/query/{pagenum}",method = RequestMethod.POST)
    public String query(@PathVariable("pagenum")String pagenum,
                        @RequestParam(value = "orderID",required = false) Integer orderID,
                        @RequestParam(value = "sendMan",required = false)String sendMan,
                        @RequestParam(value = "startTime",required = false)String startTimeStr,
                        @RequestParam(value = "endTime",required = false)String endTimeStr,
                        @RequestParam(value = "saleman",required = false)Integer saleman,
                       HttpServletRequest request,
                       Model model) {
        System.out.println("startTime--"+startTimeStr);
        System.out.println("endTime--"+endTimeStr);

        //表单对于没填的设置默认值
        if(orderID==null)orderID=-1;
        if(sendMan==null||sendMan.trim().equals(""))sendMan="";
        if(saleman==null)saleman=-1;
        Date startTime=null,endTime=null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        if(startTimeStr==null||startTimeStr.trim().equals("")){
            startTime=new Date(0l);
        }else{
            try {
                startTime = format.parse(startTimeStr.replace("T"," "));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        if(endTimeStr==null||endTimeStr.trim().equals("")){
            endTime=new Date(System.currentTimeMillis()+OFFSET);
        }else{
            try {
                endTime = format.parse(endTimeStr.replace("T"," "));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        String url = request.getContextPath()+"/order/query/";
        Page<Order> page = orderService.searchOrders(orderID,sendMan,startTime,endTime,saleman,pagenum,url);
        model.addAttribute("page", page);
        System.out.println(page);
        return "order_list";
    }

    @RequestMapping(value = "/{orderID}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("orderID") int orderID,
                         Model model) {
        int result = orderService.deleteOrder(orderID);
        if (result <= 0) {
            model.addAttribute("message", "删除订单失败！！！");
            return "message";
        } else {
            model.addAttribute("message", "删除订单成功！！！");
            return "message";
        }
    }

    @RequestMapping(value = "/{orderID}/update", method = RequestMethod.GET)
    public String update(@PathVariable("orderID") int orderID,
                         HttpServletRequest request,
                         Model model) {
        Order order = orderService.queryById(orderID);
        System.out.println(order);
        model.addAttribute("order", order);
        model.addAttribute("title", "修改订单");
        model.addAttribute("url", request.getContextPath()+"/order/"+order.getOrderID()+"/updateorder");

        List<Worker> workers = userService.listWorkers();
        model.addAttribute("workers",workers);

        List<Flower> flowers = productService.queryAll();
        model.addAttribute("flowers",flowers);
        return "order_edit";
    }

    @RequestMapping(value = "/{orderID}/updateorder", method = RequestMethod.POST)
    public String updateorder(@PathVariable("orderID") int orderID,
                                @RequestParam("sendTimeShow") String sendTimeShow,
                                @RequestParam("receiveName") String receiveName,
                                @RequestParam("receiveTel") String receiveTel,
                                @RequestParam("receiveAdd") String receiveAdd,
                                @RequestParam("payState") short payState,
                                @RequestParam("salesman") int salesman,
                                @RequestParam("sendState") short sendState,
                                @RequestParam("remarks") String remarks,
                                @RequestParam("status") short status,
                                @RequestParam("flowerID") int flowerID,
                                @RequestParam("sendName") String sendName,
                                @RequestParam("quantity") int quantity,
                                Model model) {
        Order order = new Order();
        order.setRemarks(remarks);
        order.setStatus(status);
        order.setSendState(sendState);
        order.setFlowerID(flowerID);
        order.setSendTimeShow(sendTimeShow);
        order.setPayState(payState);
        order.setSendName(sendName);
        order.setSalesman(salesman);
        order.setReceiveAdd(receiveAdd);
        order.setReceiveName(receiveName);
        order.setReceiveTel(receiveTel);
        order.setOrderID(orderID);
        order.setQuantity(quantity);
        int result = orderService.updateOrder(order);
        if (result >= 1) {
            model.addAttribute("message", "订单修改成功！！！");
        } else {
            model.addAttribute("message", "订单修改失败！！！");
        }
        return "message";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(HttpServletRequest request, Model model) {
        model.addAttribute("title", "添加订单");
        model.addAttribute("url", request.getContextPath() + "/order/addorder");

        List<Worker> workers = userService.listWorkers();
        model.addAttribute("workers",workers);

        List<Flower> flowers = productService.queryAll();
        model.addAttribute("flowers",flowers);
        return "order_edit";
    }

    @RequestMapping(value = "/addorder", method = RequestMethod.POST)
    public String addorder(@RequestParam("sendTimeShow") String sendTimeShow,
                           @RequestParam("receiveName") String receiveName,
                           @RequestParam("receiveTel") String receiveTel,
                           @RequestParam("receiveAdd") String receiveAdd,
                           @RequestParam("payState") short payState,
                           @RequestParam("salesman") int salesman,
                           @RequestParam("sendState") short sendState,
                           @RequestParam("remarks") String remarks,
                           @RequestParam("status") short status,
                           @RequestParam("flowerID") int flowerID,
                           @RequestParam("sendName") String sendName,
                           @RequestParam("quantity") int quantity,
                             Model model) {
        System.out.println("addorder");
        Order order = new Order();
        order.setRemarks(remarks);
        order.setStatus(status);
        order.setSendState(sendState);
        order.setFlowerID(flowerID);
        order.setSendTimeShow(sendTimeShow);
        order.setOrderDate(new Date());
        order.setPayState(payState);
        order.setSendName(sendName);
        order.setSalesman(salesman);
        order.setReceiveAdd(receiveAdd);
        order.setReceiveName(receiveName);
        order.setReceiveTel(receiveTel);
        order.setQuantity(quantity);

        int result = orderService.addOrder(order);
        if (result >= 1) {
            model.addAttribute("message", "订单添加成功！！！");
        } else {
            model.addAttribute("message", "订单添加失败！！！");
        }
        return "message";
    }
}
