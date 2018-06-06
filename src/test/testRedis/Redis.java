package testRedis;

import redis.clients.jedis.Jedis;

/**
 * @ClassName Redis
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/6/6 9:22
 * @Version 1.0
 **/
public class Redis {

    public static void main(String[] args) {
        //Connecting to Redis server on localhost

        String host  = "localhost";
        int port = 6379;
        Jedis jedis = null;
        try {
            jedis = new Jedis(host,port);
            jedis.auth("123123");
            jedis.select(1);
            jedis.set("name","kun");
            String name = jedis.get("name");
            System.out.println("name = " + name);
            jedis.flushDB();
            String name2 = jedis.get("name");
            System.out.println("name2 = " + name2);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != jedis){
                try {
                    jedis.close();
                }catch (Exception e){
                    System.out.println("redis连接关闭失败");
                    e.printStackTrace();
                }
            }
        }
        //set the data in redis string
        jedis.set("tutorial-name", "Redis tutorial");
        // Get the stored data and print it
        System.out.println("Stored string in redis:: "+ jedis.get("tutorialname"));
    }
}
