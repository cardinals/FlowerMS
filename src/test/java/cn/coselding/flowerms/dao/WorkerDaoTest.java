package cn.coselding.flowerms.dao;

import cn.coselding.flowerms.model.Worker;
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
public class WorkerDaoTest {

    @Resource
    private WorkerDao workerDao;

    @Test
    public void testInsert() throws Exception {
        Worker worker=new Worker();
        worker.setStatus((short)1);
        worker.setWorkername("worker1");
        workerDao.insert(worker);
    }

    @Test
    public void testDelete() throws Exception {
        workerDao.delete(100);
    }

    @Test
    public void testUpdate() throws Exception {
        Worker worker=new Worker();
        worker.setStatus((short)1);
        worker.setWorkername("worker2");
        worker.setWorkerID(105);
        workerDao.update(worker);
    }

    @Test
    public void testQueryById(){
        System.out.println(workerDao.queryById(101));
    }

    @Test
    public void testQueryAll() throws Exception {
        List<Worker> workers = workerDao.queryAll();
        System.out.println(workers);

    }
}