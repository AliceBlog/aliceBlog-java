package com.witdor.core.service;

import com.witdor.core.model.UserModel;
import org.springframework.data.domain.Page;

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
public interface UserService {

    UserModel findById(Long id);

    UserModel findByUserName(String userName);

    Page<UserModel> findAll(int start, int pageSize);

    List<UserModel> findAll();

    void delById(Long id);

    void update(UserModel model);

    void add(UserModel model);


}
