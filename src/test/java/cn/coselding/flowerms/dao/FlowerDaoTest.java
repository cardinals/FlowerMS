package cn.coselding.flowerms.dao;

import cn.coselding.flowerms.model.Flower;
import cn.coselding.flowerms.model.SpringTest;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class FlowerDaoTest {

    @Resource
    private FlowerDao flowerDao;

    @Test
    public void testInsert() throws Exception {
        Flower flower = new Flower();
        flower.setFlowerName("虎皮兰");
        flower.setImages("yujinxiang.png");
        flower.setNumber(300);
        flower.setPrice(20.0);
        flower.setRemarks("三角梅");
        flowerDao.insert(flower);
    }

    @Test
    public void testDelete() throws Exception {
        flowerDao.delete(35);
    }

    @Test
    public void testUpdate() throws Exception {
        Flower flower = new Flower();
        flower.setFlowerName("三角梅");
        flower.setImages("三角梅.png");
        flower.setNumber(300);
        flower.setPrice(20.0);
        flower.setRemarks("三角梅");
        flower.setFlowerID(34);
        flowerDao.update(flower);
    }

    @Test
    public void testQueryById() throws Exception {
        Flower flower = flowerDao.queryById(34);
        System.out.println(flower);
    }

    @Test
    public void testQueryPage() throws Exception {
        List<Flower> flowers = flowerDao.queryPage(1, 2);
        System.out.println(flowers);
    }

    @Test
    public void testQueryCount() throws Exception {
        System.out.println(flowerDao.queryCount());
    }

    @Test
    public void testQueryPageByName() throws Exception {
        List<Flower> flowers = flowerDao.queryPageByName("茉莉",0, 2);
        System.out.println(flowers);
    }

    @Test
    public void testQueryCountByName() throws Exception {
        System.out.println(flowerDao.queryCountByName("茉莉"));
    }

    @Test
    public void testSpringBean() throws CloneNotSupportedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        System.out.println(sqlSessionFactory);
        System.out.println(sqlSessionFactory);

        SpringTest springTest = (SpringTest) context.getBean("SpringTest");
        System.out.println(springTest);
        System.out.println(springTest.clone());
    }
}