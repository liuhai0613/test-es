package com.pkulaw.tec.entity.po.nested.article;

import com.pkulaw.tec.entity.po.ArticleBean;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * Created by liuhai on 2020/12/28 13:22
 */
@Data
public class OperateRecord {
    @Field(type = FieldType.Keyword)
    private String type;
    @Field(type = FieldType.Keyword)
    private String operator;
    @Field(type = FieldType.Date,format = DateFormat.custom,pattern = ArticleBean.pattern)
    private Date updateTime;
    @Field(type = FieldType.Keyword)
    private String reason;
    @Field(type = FieldType.Text)
    private String detailReason;

}
