package com.witdor.core.service.impl;

import com.witdor.core.dao.BlogDao;
import com.witdor.core.model.BlogModel;
import com.witdor.core.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;


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
 * @Date: 2016/9/5　17:27
 * @Description:
 * @Copyright(©) 2016 by xiaomo.
 **/
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao dao;

    @Override
    public BlogModel findBlogById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public Page<BlogModel> findAll(int start, int pageSize) {
        //        for (Iterator<BlogModel> it = blogModels.iterator(); it.hasNext(); ) {
//            if (it.next().getStatus() == 1) {//去掉己删除的博客
//                it.remove();
//            }
//        }
        Sort sort = new Sort(Sort.Direction.DESC, "vote");
        return dao.findAll(new PageRequest(start - 1, pageSize, sort));
    }

    @Override
    public BlogModel addBlog(BlogModel model) {
        model.setCreateTime(new Date());
        model.setUpdateTime(new Date());
        return dao.save(model);
    }

    @Override
    public BlogModel updateBlog(BlogModel model) {
        BlogModel updateBlog = dao.findOne(model.getId());
        if (updateBlog == null) {
            return null;
        }
        if (model.getAuthor() != null) {
            updateBlog.setAuthor(model.getAuthor());
        }
        if (model.getContent() != null) {
            updateBlog.setContent(model.getContent());
        }
        if (model.getSummary() != null) {
            updateBlog.setSummary(model.getSummary());
        }
        if (model.getTitle() != null) {
            updateBlog.setTitle(model.getTitle());
        }
        return dao.save(model);
    }

    @Override
    public BlogModel deleteBlogById(Long id) {
        BlogModel blogModel = dao.findOne(id);
        if (blogModel != null) {
            dao.delete(id);
            return blogModel;
        }
        return null;
    }

    @Override
    public BlogModel findBlogByTitle(String title) {
        return dao.findByTitle(title);
    }
}
