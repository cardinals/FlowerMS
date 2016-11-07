package cn.coselding.flowerms.web;

import cn.coselding.flowerms.dto.Page;
import cn.coselding.flowerms.model.Flower;
import cn.coselding.flowerms.model.Order;
import cn.coselding.flowerms.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private OrderService orderService;


    @RequestMapping(value = "/list/{pagenum}", method = RequestMethod.GET)
    public String list(@PathVariable("pagenum") String pagenum,
                       HttpServletRequest request,
                       Model model) {
        String url = request.getContextPath()+"/customer/list/";
        Page<Order> page = orderService.queryCustomer(pagenum,url);
        model.addAttribute("page", page);
        return "customer_list";
    }

    @RequestMapping(value = "/query/{pagenum}", method = RequestMethod.POST)
    public String query(@PathVariable("pagenum") String pagenum,
                        @RequestParam("customerName")String customerName,
                       HttpServletRequest request,
                       Model model) {
        String url = request.getContextPath()+"/customer/query/";
        Page<Order> page = orderService.queryCustomerByName(customerName,pagenum,url);
        model.addAttribute("page", page);
        return "customer_list";
    }

    @RequestMapping(value = "/{sendName}/delete", method = RequestMethod.POST)
    public String list(@PathVariable("sendName") String sendName,
                       Model model) {
        int result = orderService.deleteCustomer(sendName);
        if(result>=1){
            model.addAttribute("message", "客户删除成功！！！");
        }else {
            model.addAttribute("message", "客户删除失败！！！");
        }
        return "message";
    }
}
