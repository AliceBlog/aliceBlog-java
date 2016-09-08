package com.witdor.core.service.impl;

import com.witdor.core.dao.TechnologyFilesDao;
import com.witdor.core.model.TechnologyFilesModel;
import com.witdor.core.service.TechnologyFilesService;
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
public class TechnologyFilesServiceImpl implements TechnologyFilesService {

    @Autowired
    private TechnologyFilesDao technologyFilesDao;

    @Override
    public TechnologyFilesModel findTechnologyFileById(Long id) {
        return technologyFilesDao.findOne(id);
    }

    @Override
    public Page<TechnologyFilesModel> findAll(int start, int pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        return technologyFilesDao.findAll(new PageRequest(start - 1, pageSize, sort));
    }

    @Override
    public TechnologyFilesModel addTechnologyFile(TechnologyFilesModel model) {
        model.setCreateTime(new Date());
        model.setUpdateTime(new Date());
        return technologyFilesDao.save(model);
    }

    @Override
    public TechnologyFilesModel updateTechnologyFile(TechnologyFilesModel model) {
        TechnologyFilesModel technologyFilesModel = technologyFilesDao.findOne(model.getId());
        if (technologyFilesModel == null) {
            return null;
        }
        if (model.getAuthor() != null) {
            technologyFilesModel.setAuthor(model.getAuthor());
        }
        if (model.getContent() != null) {
            technologyFilesModel.setContent(model.getContent());
        }
        if (model.getTitle() != null) {
            technologyFilesModel.setTitle(model.getTitle());
        }
        if (model.getTags() != null) {
            technologyFilesModel.setTags(model.getTags());
        }
        if (model.getImg() != null) {
            technologyFilesModel.setImg(model.getImg());
        }
        technologyFilesModel.setUpdateTime(new Date());
        return technologyFilesDao.save(technologyFilesModel);
    }

    @Override
    public TechnologyFilesModel deleteTechnologyFileById(Long id) {
        TechnologyFilesModel technologyFilesModel = technologyFilesDao.findOne(id);
        if (technologyFilesModel != null) {
            technologyFilesDao.delete(id);
            return technologyFilesModel;
        }
        return null;
    }

    @Override
    public TechnologyFilesModel findTechnologyFileByTitle(String title) {
        return technologyFilesDao.findByTitle(title);
    }
}
