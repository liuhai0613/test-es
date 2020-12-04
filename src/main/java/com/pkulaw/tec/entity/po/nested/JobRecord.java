package com.pkulaw.tec.entity.po.nested;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * Created by liuhai on 2020/11/28 21:54
 */
@Data
public class JobRecord {
    @Field(type = FieldType.Keyword)
    private String city;
    @Field(type = FieldType.Text)
    private String jobDetail;
    @Field(type = FieldType.Double)
    private Double salary;
    @Field(type = FieldType.Integer)
    private Integer lever;
    @Field(type = FieldType.Date)
    private Date beginTime;
    @Field(type = FieldType.Boolean)
    private Boolean isExcellent;
}
