package com.witdor.core.model;

import com.witdor.core.model.base.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
 * @Date: 2016/9/5 17:17
 * @Description: 技术文档表
 * @Copyright(©) 2016 by xiaomo.
 **/
@Entity
@Table(name = "technology_file")
public class TechnologyFilesModel extends BaseModel implements Serializable {

    @Column(name = "title", columnDefinition = "text")
    private String title;

    @Column(name = "summary", columnDefinition = "text")
    private String summary;

    @Column(name = "content", columnDefinition = "longtext")
    private String content;

    private String author;

    private String img;

    private int[] tags;

    public int[] getTags() {
        return tags;
    }

    public void setTags(int[] tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
