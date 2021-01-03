package com.pkulaw.tec.entity.po;

import com.pkulaw.tec.entity.po.nested.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by liuhai on 2020/12/28 8:53
 */
@Document(indexName = "houyi_qikan_article_dev",shards = 3,replicas = 2, type="info")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleBean {
    @Id
    private Long id;
    //文章ID
    @Field(type = FieldType.Integer)
    private Integer InfoId;
    //期刊id
    @Field(type = FieldType.Keyword)
    private String JournalId;
    //文章类型
    @Field(type = FieldType.Keyword)
    private String NameType;
    //期刊年份
    @Field(type = FieldType.Keyword)
    private String JournalYear;
    //期号
    @Field(type = FieldType.Integer)
    private Integer JournalIssue;
    //文章状态
    @Field(type = FieldType.Integer)
    private Integer articleStatus;
    //专题分类id
    @Field(type = FieldType.Keyword)
    private String SpecialId;
    //专题分类名称
    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String SpecialName;
    //修改日期(前台)
    @Field(type = FieldType.Date)
    private Date UpdateTime;
    //PDF状态
    @Field(type = FieldType.Integer)
    private Integer IsUpLoadPdf;
    //确认状态
    @Field(type = FieldType.Keyword)
    private String Info_Preview;
    //收录时间
    @Field(type = FieldType.Date)
    private Integer uploadtime;
    //排序
    @Field(type = FieldType.Integer)
    private Integer sortNum;
    //智能学科分类
    @Field(type = FieldType.Keyword)
    private String Info_Kind;
    //人工学科分类
    @Field(type = FieldType.Keyword)
    private String Info_ManArticleKing;
    //被引频次
    @Field(type = FieldType.Integer)
    private Integer BeReferencedNum;
    //下载量
    @Field(type = FieldType.Integer)
    private Integer DownNum;
    //阅读量
    @Field(type = FieldType.Integer)
    private Integer BrowseNum;
    //操作人
    @Field(type = FieldType.Keyword)
    private String operate_user;
    //总期数
    @Field(type = FieldType.Keyword)
    private String Journal_AllIssue_new;
    //实际期号
    @Field(type = FieldType.Keyword)
    private String Joutnal_ActualIssue;
    //中文标题
    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String InfoTitle;
    //中文标题（自定义）
    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String CustomCtitle;
    //中文副标题
    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String InfoSubTitle;
    //英文标题（自定义）
    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String CustomTitleEn;
    //英文标题
    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String InfoTitleEn;
    //英文副标题
    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String InfoSubTitleEn;
    //中文关键词
    @Field(type = FieldType.Keyword)
    private String InfoKeyword;
    //期刊栏目
    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String PeriodicalColumn;
    //中图分类号
    @Field(type = FieldType.Keyword)
    private String Info_Sortnum;
    //英文关键词
    @Field(type = FieldType.Keyword)
    private String InfoKeywordEn;
    //文献标识码
    @Field(type = FieldType.Keyword)
    private String InfoIdCode;
    //起始页码
    @Field(type = FieldType.Integer)
    private Integer InfoPage;
    //终止页码
    @Field(type = FieldType.Integer)
    private Integer Info_EndPage;
    //中文摘要
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String InfoSummary;
    //英文摘要
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String InfoSummaryEn;
    //注释
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String InfoRemark;
    //参考文献
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String InfoReference;
    //引证关系
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String ReferenceRelationship;
    //中英文对照gid
    @Field(type = FieldType.Keyword)
    private String RelatedGid;
    //pdf文件路径
    @Field(type = FieldType.Keyword)
    private String InfoPdfName;
    //文章编码
    @Field(type = FieldType.Keyword)
    private String InfoCoding;
    //文章分类（目录或内容）
    @Field(type = FieldType.Integer)
    private Integer Info_Flag;
    //推荐排序
    @Field(type = FieldType.Keyword)
    private String InfoSortNum;
    //总期号
    @Field(type = FieldType.Keyword)
    private String JournalAllIssue;
    //就是gid，主键加掩码算的
    @Field(type = FieldType.Keyword)
    private String CGid;
    //关键词
    @Field(type = FieldType.Keyword)
    private String Keyword;
    //Pdf大小
    @Field(type = FieldType.Integer)
    private Integer ContentPdfPage;
    //内容
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String ContentTxt;
    //全文或目录
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String NameFlag;
    //引用的文章和条
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String ReferenceArticleGidTiaoNum;
    //检索全文
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String CheckFullText;
    //大分类
    @Field(type = FieldType.Keyword)
    private String Category;
    //字数
    @Field(type = FieldType.Integer)
    private Integer ContentTxtLen;
    //是否被引用过
    @Field(type = FieldType.Integer)
    private Integer IsBeReferenced;
    //导航信息
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String NavCatalog;
    //相关案例数
    @Field(type = FieldType.Keyword)
    private String RelatedCaseNum;
    //相似文献数
    @Field(type = FieldType.Keyword)
    private String SimilarArticleNum;
    //引证文献数
    @Field(type = FieldType.Keyword)
    private String RelatedArticlesNum;
    //ISSN
    @Field(type = FieldType.Keyword)
    private String ISSN;
    //CN
    @Field(type = FieldType.Keyword)
    private String CN;
    //基金
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String Fund;
    //被引文献
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String Citedliterature;
    //期刊栏目名称
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String PeriodicalColumnName;
    //主办单位
    @Field(type = FieldType.Keyword)
    private String InfoAuthorUnit;
    //出版周期
    @Field(type = FieldType.Keyword)
    private String PublishCycle;
    //期刊来源
    @Field(type = FieldType.Keyword)
    private String NameSource;
    //期刊类型
    @Field(type = FieldType.Keyword)
    private String NameCategory;
    //正副标题检索字段(数组)
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String LongTitle;
    //正副标题检索字段（数组）
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String LongTitleEn;
    //学科分类名称
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String InfoManArticleKingName;
    //专题标识
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String Specialtopic;
    //删除前状态
    @Field(type = FieldType.Integer)
    private Integer beforeDelStatus;
    //修改时间(后台)
    @Field(type = FieldType.Date)
    private Date InfoChangeTime;
    //期刊中文名称
    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String NameCName;
    //期刊英文名称
    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private String NameEName;
    //-------------------------------------------作者相关---------------------------------------------
    //作者和单位关系是否建立
    @Field(type = FieldType.Integer)
    private Integer buildRelation;
    //作者名称数组
    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private List<String> InfoAuthor;
    //作者单位名称数组
    @MultiField(mainField = @Field(type = FieldType.Text,analyzer = "ik_max_word"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword))
    private List<String> AuthorUnit;
    @Field(type = FieldType.Nested)
    private List<AuthorAndUnitInfo> authorAndUnitInfo;
    //作者信息
    @Field(type = FieldType.Nested)
    private List<AuthorInfo> authorInfo;
    //单位信息
    @Field(type = FieldType.Nested)
    private List<AuthorUnitInfoJobs> authorUnitInfo;
    //----------------------------------------------作者相关--------------------------------------------
    //操作记录
    @Field(type = FieldType.Nested)
    private List<OperateRecord> operateRecord;
    //是否纳入影响因子统计源
    @Field(type = FieldType.Integer)
    private Integer statisticsIF;
}
