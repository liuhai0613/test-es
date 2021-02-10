package com.pkulaw.tec.entity.po.nested.article;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 文章正文分页实体
 * Created by liuhai on 2021/1/26 18:08
 */
@Data
public class PageContentTxt {
    //页码
    @Field(type = FieldType.Integer)
    private Integer pageNo;
    //分页的正文
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String contentTxt;
}
