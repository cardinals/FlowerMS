package cn.coselding.flowerms.dao;

import cn.coselding.flowerms.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
public interface UserDao {

    int addUser(User user);

    User queryById(int userID);

    List<User> queryAdmins();

    User query4Login(@Param("username") String username, @Param("password")String password);
}
