package com.witdor.web.controller;

import com.witdor.core.controller.BaseController;
import com.witdor.core.model.TagModel;
import com.witdor.core.model.TechnologyFilesModel;
import com.witdor.core.service.TagService;
import com.witdor.core.service.TechnologyFilesService;
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
@RequestMapping("/technology")
public class TechnologyFilesController extends BaseController {

    @Autowired
    private TechnologyFilesService technologyFilesService;

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
        Page<TechnologyFilesModel> technologyFilesModels = technologyFilesService.findAll(start, pageSize);
        List<TagModel> tags = tagService.findAll();
        List<String> hotTags = tags.stream().map(TagModel::getName).collect(Collectors.toList());
        result.put("cardList", technologyFilesModels);
        result.put("hotTags", hotTags);
        return result;
    }


    /**
     * 根据Id查找内容
     * @param id id
     * @return 技术文档
     */
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public TechnologyFilesModel findById(@RequestParam(name = "id", defaultValue = "1") Long id) {
        return technologyFilesService.findTechnologyFileById(id);
    }


    /**
     * 增
     * @param title 标题
     * @param content 内容
     * @param img 图片
     * @param author 作者
     * @param tags 标签
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void add(@RequestParam String title,
                    @RequestParam String content,
                    @RequestParam String img,
                    @RequestParam String author,
                    @RequestParam(defaultValue = "") String[] tags) {
        TechnologyFilesModel model = new TechnologyFilesModel();
        model.setAuthor(author);
        model.setTitle(title);
        model.setContent(content);
        model.setImg(img);
        model.setTags(tags);
        technologyFilesService.addTechnologyFile(model);
    }


    /**
     * 根据id删除数据
     * @param id id
     * @return 数据
     */
    @RequestMapping(value = "delById", method = RequestMethod.GET)
    public TechnologyFilesModel delById(@RequestParam(name = "id") Long id) {
        return technologyFilesService.deleteTechnologyFileById(id);
    }


    /**
     * 根据ids删除数据
     * @param ids ids
     */
    @RequestMapping(value = "delByIds", method = RequestMethod.GET)
    public void delByIds(@RequestParam(name = "ids") Long[] ids) {
        for (Long id : ids) {
            technologyFilesService.deleteTechnologyFileById(id);
        }
    }


    /**
     * 增
     * @param title 标题
     * @param content 内容
     * @param img 图片
     * @param author 作者
     * @param tags 标签
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void update(
                    @RequestParam Long id,
                    @RequestParam String title,
                    @RequestParam String content,
                    @RequestParam String img,
                    @RequestParam String author,
                    @RequestParam(defaultValue = "") String[] tags) {
        TechnologyFilesModel model = new TechnologyFilesModel();
        model.setId(id);
        model.setAuthor(author);
        model.setTitle(title);
        model.setContent(content);
        model.setImg(img);
        model.setTags(tags);
        technologyFilesService.updateTechnologyFile(model);
    }

}
