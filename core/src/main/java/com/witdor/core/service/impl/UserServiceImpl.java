package com.witdor.core.service.impl;

import com.witdor.core.dao.UserDao;
import com.witdor.core.model.UserModel;
import com.witdor.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
 * @Date: 2016/9/9 13:44.
 * @Description:
 * @Copyright(©) 2016 by xiaomo.
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;


    @Override
    public UserModel findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public UserModel findByUserName(String userName) {
        return dao.findUserByUserName(userName);
    }

    @Override
    public Page<UserModel> findAll(int start, int pageSize) {
        return dao.findAll(new PageRequest(start - 1, pageSize));
    }

    @Override
    public List<UserModel> findAll() {
        return dao.findAll();
    }

    @Override
    public void delById(Long id) {
        dao.delete(id);
    }

    @Override
    public void update(UserModel model) {
        UserModel one = dao.findOne(model.getId());
        if (one == null) {
            return;
        }
        if (model.getPassword() != null) {
            one.setPassword(model.getPassword());
        }
        one.setUpdateTime(new Date());
        dao.save(one);
    }

    @Override
    public void add(UserModel model) {
        model.setCreateTime(new Date());
        model.setUpdateTime(new Date());
        dao.save(model);
    }
}
