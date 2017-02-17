package cn.mazekkkk.product.redis.service.impl;

import cn.mazekkkk.product.redis.service.IRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by maze on 17/1/23.
 * Todo Set 对象为字节
 */
@Service
public class RedisServiceImpl implements IRedisService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JedisPool jedisPool;

    /**
     * 获取jedis数据源
     * @return
     */
    @Override
    public Jedis getResource() {
        return jedisPool.getResource();
    }

    /**
     * 释放jedis数据源
     * @param jedis jedis线程
     */
    @SuppressWarnings("deprecation")
    @Override
    public void returnResource(Jedis jedis) {
        if(jedis != null){
            jedisPool.returnResourceObject(jedis);
        }
    }

    /**
     * 保存数据
     * @param key 数据key
     * @param value 数据内容
     */
    @Override
    public void set(String key, String value) {
        Jedis jedis=null;
        try{
            jedis = getResource();
            jedis.set(key,value);
            logger.info("Redis set success - " + key + ", value:" + value);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + value);
        }finally{
            returnResource(jedis);
        }
    }

    /**
     * 保存序列化得缓存数据
     * @param key 序列化key
     * @param value 序列化值
     */
    @Override
    public void setCache(byte[] key, byte[] value) {
        Jedis jedis=null;
        try{
            jedis = getResource();
            jedis.set(key,value);
            logger.info("Redis setCache success - " + key + ", value:" + value);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis setCache error: "+ e.getMessage() +" - " + key + ", value:" + value);
        }finally{
            returnResource(jedis);
        }
    }

    /**
     * 获取一个对象
     * @param key 数据key
     * @return
     */
    @Override
    public String get(String key) {
        String result = null;
        Jedis jedis=null;
        try{
            jedis = getResource();
            result = jedis.get(key);
            logger.info("Redis get success - " + key + ", value:" + result);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + result);
        }finally{
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 获取一个序列化的对象根据key
     * @param key 序列化key
     * @return
     */
    @Override
    public byte[] getCache(byte[] key) {
        byte[] result = null;
        Jedis jedis=null;
        try{
            jedis = getResource();
            result = jedis.get(key);
            logger.info("Redis getCache success - " + key + ", value:" + result);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis setCache error: "+ e.getMessage() +" - " + key + ", value:" + result);
        }finally{
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 删除数据
     * @param key 数据key
     */
    @Override
    public void del(String key) {
        Jedis jedis = null;
        try{
            jedis = getResource();
            jedis.del(key);
            logger.info("Redis del success - "+key+"");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Redis del error: "+e.getMessage()+" - "+key+"");
        }finally {
            returnResource(jedis);
        }
    }

    /**
     * 删除过期数据
     * @param key 数据key
     */
    @Override
    public void expire(byte[] key,Integer second) {
        Jedis jedis = null;
        try{
            jedis = getResource();
            jedis.expire(key,second);
            logger.info("Redis expire success - "+key+"");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Redis expire error: "+e.getMessage()+" - "+key+"");
        }finally {
            returnResource(jedis);
        }
    }

    /**
     * 保存db文件
     */
    @Override
    public void flushDb() {
        Jedis jedis = null;
        try{
            jedis = getResource();
            jedis.flushDB();
            logger.info("Redis flush Db");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Redis flush Db error");
        }finally {
            returnResource(jedis);
        }
    }

    /**
     * 获取数据库大小
     * @return
     */
    @Override
    public Long getDbSize() {
        Jedis jedis = null;
        Long size = 0l;
        try{
            jedis = getResource();
            size = jedis.dbSize();
            logger.info("Redis flush Db");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Redis flush Db error");
        }finally {
            returnResource(jedis);
        }
        return size;
    }
}


