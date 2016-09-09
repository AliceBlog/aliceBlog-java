package com.witdor.web.controller;

import com.witdor.core.controller.BaseController;
import com.witdor.core.model.UserModel;
import com.witdor.core.service.UserService;
import com.witdor.core.untils.MD5Util;
import com.witdor.core.untils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 *
 * @author: xiaomo
 * @github: https://github.com/qq83387856
 * @email: hupengbest@163.com
 * @QQ_NO: 83387856
 * @Date: 2016/9/9 13:40.
 * @Description:
 * @Copyright(©) 2016 by xiaomo.
 **/
@RestController
@RequestMapping("/")
public class LoginManager extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public boolean login(@RequestParam String userName, @RequestParam String password) {
        UserModel userModel = userService.findByUserName(userName);
        if (userModel == null) {
            return false;
        }
        if (!Objects.equals(MD5Util.encode(password, userModel.getSalt()), userModel.getPassword())) {
            return false;
        }
        return true;
    }


    @RequestMapping(value = "register", method = RequestMethod.POST)
    public boolean register(@RequestParam String userName, @RequestParam String password) {
        String salt = RandomUtil.createSalt();
        UserModel userModel = new UserModel();
        userModel.setUserName(userName);
        userModel.setSalt(salt);
        userModel.setPassword(MD5Util.encode(password, salt));
        userService.add(userModel);
        return true;
    }

}
