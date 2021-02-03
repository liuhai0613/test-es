package com.pkulaw.tec.entity.po.nested.article;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import java.util.List;

/**
 * Created by liuhai on 2020/12/28 13:21
 */
@Data
public class AuthorAndUnitInfo {
    //作者id
    @Field(type = FieldType.Keyword,copyTo = {"authorIds"})
    private String authorId;
    //作者名或曾用名
    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String authorName;
    //单位信息
    @Field(type = FieldType.Nested)
    List<AuthorUnitInfoJobs> authorUnits;

}
