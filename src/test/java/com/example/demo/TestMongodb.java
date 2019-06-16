package com.example.demo;

import com.mongodb.DB;
import com.mongodb.Mongo;
import org.junit.Test;

import java.util.Set;

public class TestMongodb {

    @Test
    public void testMongodb() {
        try {
            // 连接到 mongodb 服务
            Mongo mongo = new Mongo("192.168.1.35", 27017);
            //根据mongodb数据库的名称获取mongodb对象 ,
            DB db = mongo.getDB("showsomething");
            Set<String> collectionNames = db.getCollectionNames();
            // 打印出test中的集合
            for (String name : collectionNames) {
                System.out.println("collectionName===" + name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}