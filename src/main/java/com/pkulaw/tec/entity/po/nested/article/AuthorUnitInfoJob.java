package com.pkulaw.tec.entity.po.nested.article;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import java.util.List;

/**
 * 带职称的单位信息
 * Created by liuhai on 2020/12/29 19:02
 */
@Data
public class AuthorUnitInfoJob {
    @Field(type = FieldType.Keyword,copyTo = {"authorUnitsIds"})
    private String authorUnitId;

    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String authorUnitName;

    @Field(type = FieldType.Keyword)
    private List<String> positionsId;
}
