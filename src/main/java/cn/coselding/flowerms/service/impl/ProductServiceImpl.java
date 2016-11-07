package cn.coselding.flowerms.service.impl;

import cn.coselding.flowerms.dao.FlowerDao;
import cn.coselding.flowerms.dto.Page;
import cn.coselding.flowerms.model.Flower;
import cn.coselding.flowerms.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 宇强 on 2016/7/14 0014.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private FlowerDao flowerDao;

    @Override
    public int addProduct(Flower flower) {
        return flowerDao.insert(flower);
    }

    @Transactional
    @Override
    public int updateProduct(Flower flower) {
        Flower tmp = flowerDao.queryById(flower.getFlowerID());
        tmp.setRemarks(flower.getRemarks());
        tmp.setPrice(flower.getPrice());
        tmp.setNumber(flower.getNumber());
        tmp.setFlowerName(flower.getFlowerName());
        if(flower.getImages()!=null) {
            tmp.setImages(flower.getImages());
        }
        return flowerDao.update(tmp);
    }

    @Override
    public int deleteProduct(int flowerID) {
        return flowerDao.delete(flowerID);
    }

    @Override
    public Flower queryById(int productID) {
        return flowerDao.queryById(productID);
    }

    @Override
    public List<Flower> queryAll() {
        return flowerDao.queryAll();
    }

    @Transactional
    @Override
    public Page getPage(String pagenum, String url) {
        // 总记录数
        int totalrecord = flowerDao.queryCount();
        Page<Flower> page = null;
        if (pagenum == null)
            // 没传递页号，回传第一页数据
            page = new Page<Flower>(totalrecord, 1);
        else
            // 根据传递的页号查找所需显示数据
            page = new Page<Flower>(totalrecord, Integer.parseInt(pagenum));
        List<Flower> list = flowerDao.queryPage(page.getStartindex(),page.getPagesize());
        page.setList(list);
        page.setUrl(url);
        return page;
    }

    @Transactional
    @Override
    public Page<Flower> getPageByName(String flowerName, String pagenum, String url) {
        // 总记录数
        int totalrecord = flowerDao.queryCountByName(flowerName);
        Page<Flower> page = null;
        if (pagenum == null)
            // 没传递页号，回传第一页数据
            page = new Page<Flower>(totalrecord, 1);
        else
            // 根据传递的页号查找所需显示数据
            page = new Page<Flower>(totalrecord, Integer.parseInt(pagenum));
        List<Flower> list = flowerDao.queryPageByName(flowerName,page.getStartindex(),page.getPagesize());
        page.setList(list);
        page.setUrl(url);
        return page;
    }
}
