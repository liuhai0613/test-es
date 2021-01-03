package com.pkulaw.tec.entity.po;

import com.pkulaw.tec.entity.po.nested.AuthorAndUnitInfo;
import com.pkulaw.tec.entity.po.nested.AuthorInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.AliasFor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;

import java.util.List;

/**
 * Created by liuhai on 2020/12/31 20:01
 */
@Document(indexName = "liuh_test_alias",shards = 3,replicas = 2, type="info")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleTest {
    //id
    @Id
    private Long id;
    //作者id
    @Field(type = FieldType.Keyword)
    private String authorId;
    //作者和作者单位信息(有关系的)
    @Field(type = FieldType.Nested)
    private List<AuthorAndUnitInfo> authorAndUnitInfo;
    //作者信息
    @Field(type = FieldType.Nested)
    private List<AuthorInfo> authorInfo;
}
