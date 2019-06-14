package com.example.demo.controller;

import com.example.demo.Entity.UserEntity;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {

    private Logger logger = LoggerFactory.getLogger(Login.class);

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
        if(StringUtils.isEmpty(userEntity.getUsername())) {
            return "error";
        } else {
            return "main";
        }

    }

}
