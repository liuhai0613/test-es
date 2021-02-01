package com.pkulaw.tec.entity.po.nested.article;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import java.util.List;

/**
 * Created by liuhai on 2020/12/28 13:20
 */
@Data
public class AuthorInfo {

    @Field(type = FieldType.Keyword)
    private String authorId;

    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String authorName;
    //是否是外国作者0否1是
    @Field(type = FieldType.Integer)
    private String authorOfForeign;
}
