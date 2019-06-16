package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.IUserService;
import com.example.demo.serviceImpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin(origins = "http://127.0.0.1:18080")
@RequestMapping("/agent")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private IUserService service;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/simpleLogin", method = RequestMethod.POST)
    public String simpleLogin(@RequestParam("username") String username,
                        @RequestParam("password") String password) {

        logger.info("username="+ username + ",password=" + password);
        return "main";

    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletResponse httpServletResponse,
                        @RequestBody UserEntity userEntity) {

        logger.info("username=" + userEntity.getUsername() + ",password=" + userEntity.getPassword());
        httpServletResponse.setContentType("text/plain");
        httpServletResponse.setCharacterEncoding("UTF-8");

        UserEntity user = service.login(userEntity);

        if(null != user) {
            return "main";
        } else {
            return "error";
        }

    }

}
