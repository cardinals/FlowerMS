package cn.coselding.flowerms.dao;

import cn.coselding.flowerms.model.Flower;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
public interface FlowerDao {
    int insert(Flower flower);
    int delete(int flowerID);
    int update(Flower flower);

    Flower queryById(int flowerID);
    List<Flower> queryAll();

    List<Flower> queryPage(@Param("startindex") int startindex, @Param("pagesize") int pagesize);
    int queryCount();

    List<Flower> queryPageByName(@Param("flowerName") String flowerName,@Param("startindex")int startindex,@Param("pagesize")int pagesize);
    int queryCountByName(@Param("flowerName")String flowerName);
}
