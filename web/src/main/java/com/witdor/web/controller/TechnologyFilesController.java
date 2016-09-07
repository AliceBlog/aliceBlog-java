package com.witdor.web.controller;

import com.witdor.core.controller.BaseController;
import com.witdor.core.model.TagModel;
import com.witdor.core.model.TechnologyFilesModel;
import com.witdor.core.model.TechnologyTagModel;
import com.witdor.core.service.TagService;
import com.witdor.core.service.TechnologyTagService;
import com.witdor.core.service.TechnologyFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
 * @Date: 2016/9/5 17:16
 * @Description:
 * @Copyright(©) 2016 by xiaomo.
 **/
@RestController
@RequestMapping("/technology")
public class TechnologyFilesController extends BaseController {

    @Autowired
    private TechnologyFilesService technologyFilesService;

    @Autowired
    private TechnologyTagService technologyTagService;

    @Autowired
    private TagService tagService;

    /**
     * findAll
     *
     * @param id id
     */
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Page<TechnologyFilesModel> findAll(@RequestParam(name = "start",defaultValue = "1")int start,@RequestParam(name = "pageSize",defaultValue = "9999")int pageSize) {
        return technologyFilesService.findAll(start, pageSize);
    }

    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public void findById(@RequestParam(name = "id",defaultValue = "1")Long id) {
        // 技术文档
        TechnologyFilesModel technologyFile = technologyFilesService.findTechnologyFileById(id);
        // 关联关系
        List<TechnologyTagModel> technologyTagModels = technologyTagService.findById(technologyFile.getId());
        // 标签
        List<TagModel> tags = new ArrayList<>();
        for (TechnologyTagModel technologyTagModel : technologyTagModels) {
            TagModel tagModel = tagService.findById(technologyTagModel.getTagId());
            tags.add(tagModel);
        }
    }


}
