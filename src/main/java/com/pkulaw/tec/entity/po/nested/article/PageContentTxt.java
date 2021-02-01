package com.pkulaw.tec.entity.po.nested.article;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

/**
 * Created by liuhai on 2021/1/26 18:08
 */
@Data
public class PageContentTxt {

    @Field(type = FieldType.Integer)
    private Integer pageNo;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String htmlContentTxt;
}
