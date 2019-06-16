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
import static com.example.demo.utils.Constants.*;
import javax.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://127.0.0.1:18080")
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
    public String login(@RequestBody UserEntity userEntity) {

        logger.info("username=" + userEntity.getUsername() + ",password=" + userEntity.getPassword());

        UserEntity user = service.login(userEntity);

        if(null != user) {
            return "main";
        } else {
            return "error";
        }
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestBody UserEntity userEntity) {

        logger.info("username=" + userEntity.getUsername() + ",password=" + userEntity.getPassword());

        UserEntity res = service.register(userEntity);
        if(null != res) {
            return SUCCESS;
        } else {
            return FAILED;
        }
    }
}
