package com.example.demo;

import com.example.demo.entity.Article;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.internal.MongoClientImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitArticle {

    @Autowired
    private MongoTemplate mongoTemplate;

//    @Before
//    public void init() {
//        MongoDbFactory factory = new SimpleMongoClientDbFactory(new MongoClientImpl(MongoClientSettings.builder().build(), ), "test");
//        mongoTemplate = new MongoTemplate(facotry);
//    }

    @Test
    public void insertArticles() {
        //循环添加
        for (int i = 0; i < 10; i++) {
            Article article = new Article();
            article.setTitle("MongoTemplate的基本使用");
            article.setAuthor(BigInteger.valueOf(1));
            article.setTags(Arrays.asList("java", "mongodb", "spring"));
            article.setCreateTime(new Date());
            mongoTemplate.save(article);
        }

    }

}
