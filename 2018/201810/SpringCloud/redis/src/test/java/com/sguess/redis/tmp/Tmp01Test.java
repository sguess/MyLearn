package com.sguess.redis.tmp;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tmp01Test {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void testOpsForValue() throws InterruptedException {
        stringRedisTemplate.opsForValue().set("a01", "Hello");
        stringRedisTemplate.opsForValue().set("name", "tom");
        stringRedisTemplate.opsForValue().set("name", "tom", 5, TimeUnit.SECONDS);
        System.out.println("------------>" + stringRedisTemplate.opsForValue().get("name"));
        Thread.sleep(10 * 1000);
        System.out.println("------------>" + stringRedisTemplate.opsForValue().get("name"));
        HashMap<String, String> map = new HashMap<>();
        map.put("mk1", "mv1");
        map.put("mk2", "mv2");
        stringRedisTemplate.opsForValue().multiSet(map);

        List<String> list = new ArrayList<>();
        list.add("mk1");
        list.add("name");
        List<String> rst = stringRedisTemplate.opsForValue().multiGet(list);
        for (String s : rst) {
            System.out.println("--->" + s);
        }
    }

    @Test
    public void testOpsForList() {
        stringRedisTemplate.opsForList().rightPush("list01", "a1");
        stringRedisTemplate.opsForList().rightPush("list01", "a2");
        stringRedisTemplate.opsForList().rightPush("list01", "a3");
        stringRedisTemplate.opsForList().rightPush("list01", "a1");
    }

    @Test
    public void testlist02() {
        List<String> rst = stringRedisTemplate.opsForList().range("list01", 2, 3);
        for (String s : rst) {
            System.out.println("---->" + s);
        }
    }

    @Test
    public void testDomain() {
        Person person=new Person();
        person.setAge(123);
        person.setName("Tom");
        person.setBirsday(new Date());
        redisTemplate.opsForValue().set("p1",person);
    }

    class Person {
        private String name;
        private int age;
        private Date birsday;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Date getBirsday() {
            return birsday;
        }

        public void setBirsday(Date birsday) {
            this.birsday = birsday;
        }
    }
}

