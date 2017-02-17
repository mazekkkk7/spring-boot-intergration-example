package cn.mazekkkk.product.redis.service;

import redis.clients.jedis.Jedis;

/**
 * Created by maze on 17/1/23.
 */
public interface IRedisService {

    /**
     * 获取jedis数据源
     * @return
     */
    Jedis getResource();

    /**
     * 释放jedis数据源
     * @param jedis jedis线程
     */
    void returnResource(Jedis jedis);

    /**
     * 保存数据
     * @param key 数据key
     * @param value 数据内容
     */
    void set(String key, String value);

    /**
     * 保存序列化得缓存数据
     * @param key 序列化key
     * @param value 序列化值
     */
    void setCache(byte[] key,byte[] value);

    /**
     * 获取一个对象
     * @param key 数据key
     * @return
     */
    String get(String key);

    /**
     * 获取一个序列化的对象根据key
     * @param key 序列化key
     * @return
     */
    byte[] getCache(byte[] key);

    /**
     * 删除数据
     * @param key 数据key
     */
    void del(String key);

    /**
     * 删除过期数据
     * @param key 数据key
     */
    void expire(byte[] key,Integer second);

    /**
     * 保存db文件
     */
    void flushDb();

    /**
     * 获取数据库大小
     * @return
     */
    Long getDbSize();

}
