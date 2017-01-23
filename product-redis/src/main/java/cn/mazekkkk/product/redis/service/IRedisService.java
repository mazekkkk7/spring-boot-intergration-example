package cn.mazekkkk.product.redis.service;

import redis.clients.jedis.Jedis;

/**
 * Created by maze on 17/1/23.
 */
public interface IRedisService {

    public Jedis getResource();

    public void returnResource(Jedis jedis);

    public void set(String key, String value);

    public String get(String key);

}
