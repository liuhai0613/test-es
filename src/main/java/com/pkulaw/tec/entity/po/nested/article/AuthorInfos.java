package com.pkulaw.tec.entity.po.nested.article;

import com.pkulaw.tec.entity.po.ArticleBean;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.Date;

/**
 * 上传的作者与单位名称json
 * Created by liuhai on 2021/2/10 10:47
 */
@Data
public class AuthorInfos {
    //作者名称
    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String Author;
    //国籍
    @Field(type = FieldType.Keyword)
    private String Country;
    //籍贯
    @Field(type = FieldType.Text)
    private String NativePlace;
    //Birth  出生日期
    @Field(type = FieldType.Date,format = DateFormat.custom,pattern = ArticleBean.pattern)
    private Date Birth;
    //单位信息
}
