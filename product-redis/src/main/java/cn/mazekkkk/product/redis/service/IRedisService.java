package cn.mazekkkk.product.redis.service;

import redis.clients.jedis.Jedis;

/**
 * Created by maze on 17/1/23.
 */
public interface IRedisService {

    Jedis getResource();

    void returnResource(Jedis jedis);

    void set(String key, String value);

    void del(String key);

    String get(String key);

}
