package cn.coselding.flowerms.web;

import cn.coselding.flowerms.dto.Page;
import cn.coselding.flowerms.model.Flower;
import cn.coselding.flowerms.service.ProductService;
import cn.coselding.flowerms.utils.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ProductService productService;

    @RequestMapping(value = "/{productID}", method = RequestMethod.GET)
    public String info(@PathVariable("productID") int productID,
                       Model model) {
        Flower flower = productService.queryById(productID);
        model.addAttribute("flower", flower);
        return "product_info";
    }

    @RequestMapping(value = "/list/{pagenum}", method = RequestMethod.GET)
    public String list(@PathVariable("pagenum") String pagenum,
                       HttpServletRequest request,
                       Model model) {
        String url = request.getContextPath() + "/product/list/";
        Page page = productService.getPage(pagenum, url);
        model.addAttribute("page", page);
        return "product_list";
    }

    @RequestMapping(value = "/query/{pagenum}")
    public String query(@PathVariable("pagenum") String pagenum,
                        @RequestParam("flowerName")String flowerName,
                       HttpServletRequest request,
                       Model model) {
        String url = request.getContextPath() + "/product/query/";
        Page page = productService.getPageByName(flowerName,pagenum, url);
        model.addAttribute("page", page);
        return "product_list";
    }

    @RequestMapping(value = "/{productID}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("productID") int productID,
                         Model model) {
        int result = productService.deleteProduct(productID);
        if (result <= 0) {
            model.addAttribute("message", "删除花种失败！！！");
            return "message";
        } else {
            model.addAttribute("message", "删除花种成功！！！");
            return "message";
        }
    }

    @RequestMapping(value = "/{productID}/update", method = RequestMethod.GET)
    public String update(@PathVariable("productID") int productID,
                         HttpServletRequest request,
                         Model model) {
        Flower flower = productService.queryById(productID);
        model.addAttribute("flower", flower);
        model.addAttribute("title", "修改花种");
        model.addAttribute("url", request.getContextPath() + "/product/" + flower.getFlowerID() + "/updateproduct");
        return "product_edit";
    }

    @RequestMapping(value = "/{productID}/updateproduct", method = RequestMethod.POST)
    public String updateproduct(@PathVariable("productID") int productID,
                                @RequestParam("flowerName") String flowerName,
                                @RequestParam("price") double price,
                                @RequestParam("number") int number,
                                @RequestParam("remarks") String remarks,
                                @RequestParam(value = "images", required = false) MultipartFile images,
                                HttpServletRequest request,
                                Model model) {
        Flower flower = new Flower();
        flower.setFlowerID(productID);
        flower.setFlowerName(flowerName);
        flower.setNumber(number);
        flower.setPrice(price);
        flower.setRemarks(remarks);

        if(images.isEmpty()){
            flower.setImages(null);
        }else {
            System.out.println("name = "+images.getOriginalFilename());
            //保存文件
            String savePath = request.getSession().getServletContext().getRealPath("/upload");
            //TODO 测试添加
//            savePath="D:\\upload";

            String filename = WebUtil.encodeFilename(images.getOriginalFilename());
            String path = WebUtil.encodeFilePath(filename, savePath);
            try {
                images.transferTo(new File(savePath + "/" + path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            flower.setImages("/upload" + path);
        }

        int result = productService.updateProduct(flower);
        if (result >= 1) {
            model.addAttribute("message", "花种修改成功！！！");
        } else {
            model.addAttribute("message", "花种修改失败！！！");
        }
        return "message";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(HttpServletRequest request, Model model) {
        model.addAttribute("title", "添加花种");
        model.addAttribute("url", request.getContextPath() + "/product/addproduct");
        return "product_edit";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String addproduct(@RequestParam("flowerName") String flowerName,
                             @RequestParam("price") double price,
                             @RequestParam("number") int number,
                             @RequestParam("remarks") String remarks,
                             @RequestParam(value = "images",required = false) MultipartFile images,
                             HttpServletRequest request,
                             Model model) {
        Flower flower = new Flower();
        flower.setFlowerName(flowerName);
        flower.setNumber(number);
        flower.setPrice(price);
        flower.setRemarks(remarks);

        if(images.isEmpty()){
            flower.setImages(null);
        }else {
            //保存文件
            String savePath = request.getSession().getServletContext().getRealPath("/upload");
            //TODO 测试添加
//            savePath="D:\\upload";
            String filename = WebUtil.encodeFilename(images.getOriginalFilename());
            String path = WebUtil.encodeFilePath(filename, savePath);
            try {
                images.transferTo(new File(savePath + "/" + path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            flower.setImages("/upload" + path);
        }

        int result = productService.addProduct(flower);
        if (result >= 1) {
            model.addAttribute("message", "花种添加成功！！！");
        } else {
            model.addAttribute("message", "花种添加失败！！！");
        }
        return "message";
    }
}
