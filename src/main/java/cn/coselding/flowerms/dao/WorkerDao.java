package cn.coselding.flowerms.dao;

import cn.coselding.flowerms.model.Worker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
public interface WorkerDao {
    int insert(Worker worker);
    int delete(int workerID);
    int update(Worker worker);
    List<Worker> queryAll();
    List<Worker> searchWorker(@Param("workerID")int workerID,@Param("workername")String workername);
    Worker queryById(int workerID);
}
