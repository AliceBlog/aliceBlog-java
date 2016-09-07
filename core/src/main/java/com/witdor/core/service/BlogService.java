package com.witdor.core.service;

import com.witdor.core.model.BlogModel;
import org.springframework.data.domain.Page;

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
 * @Date: 2016/9/5 17:27
 * @Description: blog
 * @Copyright(©) 2016 by xiaomo.
 **/
public interface BlogService {

    BlogModel findBlogById(Long id);

    BlogModel findBlogByTitle(String title);
    
    Page<BlogModel> findAll(int start ,int pageSize);

    BlogModel addBlog(BlogModel model);

    BlogModel updateBlog(BlogModel model);

    BlogModel deleteBlogById(Long id);


}
