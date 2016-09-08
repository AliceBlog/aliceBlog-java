package com.witdor.core.service.impl;

import com.witdor.core.dao.TagDao;
import com.witdor.core.model.TagModel;
import com.witdor.core.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
 * @Date: 2016/9/7 18:00.
 * @Description:
 * @Copyright(©) 2016 by xiaomo.
 **/
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public TagModel findById(Long id) {
        return tagDao.findOne(id);
    }

    @Override
    public Page<TagModel> findAll(int start, int pageSize) {
        return tagDao.findAll(new PageRequest(start - 1, pageSize));
    }

    @Override
    public List<TagModel> findAll() {
        return tagDao.findAll();
    }
}
