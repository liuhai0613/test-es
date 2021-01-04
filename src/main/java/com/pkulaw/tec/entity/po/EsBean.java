package com.pkulaw.tec.entity.po;

import com.pkulaw.tec.entity.po.nested.JobRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.Date;

@Data
@Document(indexName = "liuh_test7")
@AllArgsConstructor
@NoArgsConstructor
@Setting(settingPath = "elasticsearch-settings.json")
public class EsBean {
    @Id
    private Integer id;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String name;

    @Field(type = FieldType.Integer)
    private Integer age;

    @Field(type = FieldType.Keyword)
    private String sex;

    @Field(type = FieldType.Date)
    private Date birth;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String introduce;

    @Field(type = FieldType.Boolean)
    private Boolean isMarried;

    @Field(type = FieldType.Nested)
    private JobRecord job;

    public EsBean(Integer id,String name,Integer age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
