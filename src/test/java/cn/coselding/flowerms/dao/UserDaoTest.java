package cn.coselding.flowerms.dao;

import cn.coselding.flowerms.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setAddress("福建省漳州市");
        user.setCardID("111111111111111111");
        user.setEmail("1098129797@qq.com");
        user.setName("Coselding");
        user.setPassword("123456");
        user.setTel("13210135013");
        user.setUsername("Coselding");
        userDao.addUser(user);
    }

    @Test
    public void testQueryById(){
        System.out.println(userDao.queryById(10));
    }

    @Test
    public void testQueryAdmins() throws Exception {
        List<User> users = userDao.queryAdmins();
        System.out.println(users);
    }

    @Test
    public void testQuery4Login() throws Exception {
        User user = userDao.query4Login("admin", "123456");
        System.out.println(user);
    }
}