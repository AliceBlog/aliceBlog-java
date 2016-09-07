package com.witdor.core.service;

import com.witdor.core.model.TagModel;
import com.witdor.core.model.TechnologyTagModel;
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
 * @Date: 2016/9/7 17:36.
 * @Description:
 * @Copyright(©) 2016 by xiaomo.
 **/
public interface TechnologyTagService {

    Page<TechnologyTagModel> findAll(int start, int pageSize);

    List<TechnologyTagModel> findById(Long id);

    void delById(Long id);

}
