package cn.coselding.flowerms.service.impl;

import cn.coselding.flowerms.dao.UserDao;
import cn.coselding.flowerms.dao.WorkerDao;
import cn.coselding.flowerms.model.User;
import cn.coselding.flowerms.model.Worker;
import cn.coselding.flowerms.service.UserService;
import cn.coselding.flowerms.utils.ServiceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private WorkerDao workerDao;

    @Override
    public User login(String username, String password) {
        System.out.println(password);
        password=ServiceUtil.string2MD5(password);
        System.out.println(username+" -- "+password);
        User user = userDao.query4Login(username, password);
        return user;
    }

    @Override
    public User queryUserById(int userID) {
        return userDao.queryById(userID);
    }

    @Override
    public List<User> listUsers() {
        return userDao.queryAdmins();
    }

    @Override
    public List<Worker> listWorkers() {
        return workerDao.queryAll();
    }

    @Override
    public List<Worker> queryWorkers(int workerID, String workername) {
        return workerDao.searchWorker(workerID,workername);
    }

    @Override
    public int addWorker(Worker worker) {
        return workerDao.insert(worker);
    }

    @Override
    public int deleteWorker(int workerID) {
        return workerDao.delete(workerID);
    }

    @Override
    public Worker queryById(int workerID) {
        return workerDao.queryById(workerID);
    }

    @Transactional
    @Override
    public int updateWorker(Worker worker) {
        Worker tmp = workerDao.queryById(worker.getWorkerID());
        tmp.setStatus(worker.getStatus());
        tmp.setWorkername(worker.getWorkername());
        return workerDao.update(tmp);
    }

    @Override
    public int addUser(User user) {
        user.setPassword(ServiceUtil.string2MD5(user.getPassword()));
        return userDao.addUser(user);
    }

}
