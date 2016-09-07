package com.witdor.core.dao;

import com.witdor.core.model.base.BaseModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
 * @Date: 2016/9/1 20:46
 * @Description: 公共dao层
 * @Copyright(©) 2016 by xiaomo.
 **/
@Repository
@Transactional
public class CommonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public <T extends BaseModel> T get(Class<T> type, long id) {
        return entityManager.find(type, id);
    }

    public <T extends BaseModel> T update(T entity) {
        return entityManager.merge(entity);
    }

    public <T extends BaseModel> void save(T entity) {
        entityManager.persist(entity);
    }

    public <T extends BaseModel> void delete(T entity) {
        entityManager.remove(entity);
    }

    public <T extends BaseModel> List getAll(Class<? extends BaseModel> tableClass) {
        Query query = entityManager.createQuery("from " + tableClass.getSimpleName());
        return query.getResultList();
    }


}