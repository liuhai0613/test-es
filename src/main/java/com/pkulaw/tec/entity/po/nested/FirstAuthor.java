package com.pkulaw.tec.entity.po.nested;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

/**
 * Created by liuhai on 2020/12/30 9:06
 */
@Data
public class FirstAuthor {

    @Field(type = FieldType.Keyword)
    private String authorId;

    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String authorName;
}
