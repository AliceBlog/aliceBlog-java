package com.witdor.web.controller;

import com.witdor.core.controller.BaseController;
import com.witdor.core.service.TechnologyFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
 * @Date: 2016/9/5 17:16
 * @Description:
 * @Copyright(©) 2016 by xiaomo.
 **/
@RestController
@RequestMapping("/technology")
public class TechnologyFilesController extends BaseController {

    @Autowired
    private TechnologyFilesService service;

    /**
     * findAll
     *
     * @param id id
     */
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public void findAll() {

    }


}
