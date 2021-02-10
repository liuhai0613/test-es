package com.pkulaw.tec.entity.po.nested.article;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

/**
 * 外国作者实体
 * Created by liuhai on 2020/12/30 9:06
 */
@Data
public class ForeignAuthor {

    @Field(type = FieldType.Keyword)
    private String authorId;

    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "standard"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String authorName;
}
