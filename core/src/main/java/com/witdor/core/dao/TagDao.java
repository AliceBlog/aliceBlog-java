package com.witdor.core.dao;

import com.witdor.core.model.TagModel;
import org.springframework.data.jpa.repository.JpaRepository;

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
 * @Date: 2016/9/7 17:59.
 * @Description:
 * @Copyright(©) 2016 by xiaomo.
 **/
public interface TagDao extends JpaRepository<TagModel,Long> {
}
