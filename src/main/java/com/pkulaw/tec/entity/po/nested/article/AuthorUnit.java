package com.pkulaw.tec.entity.po.nested.article;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

/**
 * 作者单位id、name
 * Created by liuhai on 2021/1/12 9:23
 */
@Data
public class AuthorUnit {
    @Field(type = FieldType.Keyword)
    private String authorUnitId;

    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String authorUnitName;
}
