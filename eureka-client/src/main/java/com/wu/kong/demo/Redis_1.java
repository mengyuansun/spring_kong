package com.wu.kong.demo;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Redis_1 {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("106.54.23.150");
        jedis.auth("runoob");//Redis 密码
//        str(jedis);
//        test(jedis);
//        list_test(jedis);
        hash_test(jedis);
    }

    public static void str(Jedis jedis) {
        //连接Redis服务
        jedis.auth("runoob");//Redis 密码
        System.out.println("连接成功");
        //设置 redis字符串数据
        jedis.set("sun", "mengyuan");
        System.out.println("redis 存储的字符串为： " + jedis.get("sun"));
    }

    public static void test(Jedis jedis) {
        //连接Redis服务
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行： " + jedis.ping());
    }

    public static void list_test(Jedis jedis) {
        //连接本地 的 Redis服务
        jedis.lpush("site-list", "张三");
        jedis.lpush("site-list", "李四");
        jedis.lpush("site-list", "王五");
        //获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("列表项为： " + list.get(i));
        }
    }

    public static void hash_test(Jedis jedis) {
        //连接本地 的 Redis服务
        Map<String, String> mp = new HashMap<String, String>();
        mp.put("sun1", "666");
        mp.put("meng", "777");
        System.out.println(mp.keySet());
        jedis.hmset("sun555", mp);
        for (String key : mp.keySet()) {
            System.out.println("hash 的： " + key + "为" + jedis.hget("sun555", key));
        }


    }
}
