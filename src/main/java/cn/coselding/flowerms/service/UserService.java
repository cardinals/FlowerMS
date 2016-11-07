package cn.coselding.flowerms.service;

import cn.coselding.flowerms.model.User;
import cn.coselding.flowerms.model.Worker;

import java.util.List;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
public interface UserService {

    User login(String username,String password);
    User queryUserById(int userID);

    List<User> listUsers();
    int addUser(User user);

    List<Worker> listWorkers();
    List<Worker> queryWorkers(int workerID,String workername);
    int addWorker(Worker worker);
    int deleteWorker(int workerID);
    Worker queryById(int workerID);
    int updateWorker(Worker worker);


}
