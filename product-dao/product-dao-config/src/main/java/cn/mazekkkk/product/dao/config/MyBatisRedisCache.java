package cn.mazekkkk.product.dao.config;

import cn.mazekkkk.product.common.utils.SerializeUtils;
import cn.mazekkkk.product.redis.service.IRedisService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by maze on 17/2/16.
 */
public class MyBatisRedisCache implements Cache {

    private static IRedisService redisService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss" ).create();
    private String id;

    public MyBatisRedisCache(final String id) {
        if (id == null) {
            //未初始化缓存
            throw new IllegalArgumentException("cache was not init cache");
        }
        logger.info("==============MybatisRedisCache:id="+id);
        this.id = id;
    }

    /**
     * 获取id
     * @return
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * 将数据保存到Redis
     * @param key 缓存key
     * @param value 缓存value
     */
    @Override
    public void putObject(Object key, Object value) {
        redisService.setCache(SerializeUtils.serialize(key),SerializeUtils.serialize(value));
    }

    /**
     * 获取缓存的数据
     * @param key 缓存key
     * @return
     */
    @Override
    public Object getObject(Object key) {
        return SerializeUtils.unserialize(redisService.getCache(SerializeUtils.serialize(key)));
    }

    /**
     * 删除缓存中的数据
     * @param key 缓存key
     * @return
     */
    @Override
    public Object removeObject(Object key) {
        redisService.expire(SerializeUtils.serialize(key),0);
        return key.toString();
    }

    /**
     * 清空缓存Db
     */
    @Override
    public void clear() {
        redisService.flushDb();
    }

    /**
     * 获取缓存Db的长度
     * @return
     */
    @Override
    public int getSize() {
        return Math.toIntExact(redisService.getDbSize());
    }

    /**
     * 获取读写锁
     * @return
     */
    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    /**
     * 提供静态注入redis的方法
     * @param iRedisService redis服务
     */
    public static void setRedisService(IRedisService iRedisService){
        MyBatisRedisCache.redisService = iRedisService;
    }
}
