package cn.coselding.flowerms.service;

import cn.coselding.flowerms.dto.Page;
import cn.coselding.flowerms.model.Flower;

import java.util.List;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
public interface ProductService {

    int addProduct(Flower flower);
    int updateProduct(Flower flower);
    int deleteProduct(int flowerID);
    Flower queryById(int productID);
    List<Flower> queryAll();
    Page<Flower> getPage(String pagenum, String url);
    Page<Flower> getPageByName(String flowerName,String pagenum,String url);
}
