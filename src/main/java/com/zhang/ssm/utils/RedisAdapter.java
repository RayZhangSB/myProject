package com.zhang.ssm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @ClassName RedisAdapter
 * @Description: 使用spring配置的redis连接池进行管理redis操作
 * @Author Raymond Zhang
 * @Date 2018/6/6 9:44
 * @Version 1.0
 **/
@Repository("redisClientApi")
public final class RedisAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisAdapter.class);
    @Autowired
    private static ShardedJedisPool shardedJedisPool;

    //获取redis连接
    public static  ShardedJedis getRedisConn() {
        ShardedJedis shardJedis = null;
        try {
             shardJedis = shardedJedisPool.getResource();
        } catch (Exception e) {
           LOGGER.error("获取redis连接失败"+e.getMessage());
        }
        return shardJedis;

    }


}
