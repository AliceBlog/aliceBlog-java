package com.witdor.core.service;

import com.witdor.core.model.TechnologyFilesModel;
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
 * @Description: TechnologyFile
 * @Copyright(©) 2016 by xiaomo.
 **/
public interface TechnologyFilesService {

    TechnologyFilesModel findTechnologyFileById(Long id);

    TechnologyFilesModel findTechnologyFileByTitle(String title);
    
    Page<TechnologyFilesModel> findAll(int start , int pageSize);

    TechnologyFilesModel addTechnologyFile(TechnologyFilesModel model);

    TechnologyFilesModel updateTechnologyFile(TechnologyFilesModel model);

    TechnologyFilesModel deleteTechnologyFileById(Long id);


}
