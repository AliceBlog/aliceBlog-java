package com.witdor.web.controller;

import com.witdor.core.controller.BaseController;
import com.witdor.core.model.TagModel;
import com.witdor.core.model.TechnologyFilesModel;
import com.witdor.core.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
@RequestMapping("/tag")
public class TagController extends BaseController {

    @Autowired
    private TagService tagService;

    /**
     * 查询所有
     *
     * @param id id
     */
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public HashMap<String, Object> findAll(@RequestParam(name = "start", defaultValue = "1") int start, @RequestParam(name = "pageSize", defaultValue = "9999") int pageSize) {
        result = new HashMap<>();
        Page<TagModel> tags = tagService.findAll(start, pageSize);
        List<TagModel> content = tags.getContent();
        List<String> hotTags = content.stream().map(TagModel::getName).collect(Collectors.toList());
        result.put("hotTags", hotTags);
        return result;
    }


    /**
     * 根据Id查找内容
     *
     * @param id id
     * @return 技术文档
     */
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public TagModel findById(@RequestParam(name = "id", defaultValue = "1") Long id) {
        return tagService.findById(id);
    }


    /**
     * 增
     *
     * @param name 名字
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void add(@RequestParam String name) {
        TagModel model = new TagModel();
        model.setName(name);
        tagService.add(model);
    }


    /**
     * 根据id删除数据
     *
     * @param id id
     */
    @RequestMapping(value = "delById", method = RequestMethod.GET)
    public void delById(@RequestParam(name = "id") Long id) {
        tagService.delById(id);
    }


    /**
     * 根据id删除数据
     *
     * @param ids ids
     */
    @RequestMapping(value = "delByIds", method = RequestMethod.GET)
    public void delByIds(@RequestParam(name = "ids") Long[] ids) {
        for (Long id : ids) {
            tagService.delById(id);
        }
    }

    /**
     * 增
     *
     * @param name 名字
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void update(
            @RequestParam Long id,
            @RequestParam String name) {
        TagModel model = new TagModel();
        model.setId(id);
        model.setName(name);
        tagService.update(model);
    }
}
