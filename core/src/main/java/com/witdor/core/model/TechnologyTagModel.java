package com.witdor.core.model;

import com.witdor.core.model.base.BaseModel;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;

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
 * @Date: 2016/9/7 17:12.
 * @Description: 技术文档和标签 对应关系表
 * @Copyright(©) 2016 by xiaomo.
 **/

@Entity
@Table(name = "technology_file_connection")
public class TechnologyTagModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    private Long technologyFileId;

    public Long getTechnologyFileId() {
        return technologyFileId;
    }

    public void setTechnologyFileId(Long technologyFileId) {
        this.technologyFileId = technologyFileId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}
