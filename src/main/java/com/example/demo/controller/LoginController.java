package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.IUserService;
import com.example.demo.serviceImpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private IUserService service;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

//    @RequestMapping("/simpleLogin")
//    public String simpleLogin(@RequestParam("username") String username,
//                        @RequestParam("password") String password) {
//
//        logger.info("username="+ username + ",password=" + password);
//        return "main";
//
//    }

    @RequestMapping("/login")
    public String login(@ModelAttribute UserEntity userEntity) {

        logger.info("username=" + userEntity.getUsername() + ",password=" + userEntity.getPassword());

        UserEntity user = service.login(userEntity);

        if(null != user) {
            return "main";
        } else {
            return "error";
        }

    }

}
