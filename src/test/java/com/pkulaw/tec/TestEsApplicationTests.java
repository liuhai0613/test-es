package com.pkulaw.tec;

import com.google.common.collect.Lists;
import com.pkulaw.tec.entity.po.ArticleBean;
import com.pkulaw.tec.entity.po.EsBean;
import com.pkulaw.tec.entity.po.nested.AuthorAndUnitInfo;
import com.pkulaw.tec.mapper.ArticleMapper;
import com.pkulaw.tec.mapper.EsMapper;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.InnerHitBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.nested.ParsedNested;
import org.elasticsearch.search.aggregations.pipeline.bucketmetrics.stats.ParsedStatsBucket;
import org.elasticsearch.search.aggregations.pipeline.bucketmetrics.stats.StatsBucketPipelineAggregationBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.*;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;

@SpringBootTest
class TestEsApplicationTests {

    @Autowired
    EsMapper esMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Test
    void queryDocCountNum(){
        //组装聚合查询条件
        SearchQuery searchQuery =
                new NativeSearchQueryBuilder().withIndices("liuh_test3").withQuery(QueryBuilders.termQuery("name","张三"))
                        .withTypes("esbean")
                        .withPageable(PageRequest.of(0, 1))
                        .build();
        long count = elasticsearchRestTemplate.count(searchQuery);
        System.out.println(count);
    }
    @Test
    void queryAuthorNum(){
        //netsed
        NestedAggregationBuilder nestedAggBuilder = AggregationBuilders.nested("queryAuthorNum",
                "authorAndUnitInfo");
        //1层
        AggregationBuilder userNumberAggBuilder = AggregationBuilders.terms("authorIdAggs")
                .field("authorAndUnitInfo.authorId").size(1000000);
        //pipeline
        StatsBucketPipelineAggregationBuilder pipelineBuilder = new StatsBucketPipelineAggregationBuilder("bucketSum","authorIdAggs._count");
        //嵌套
        nestedAggBuilder.subAggregation(pipelineBuilder);
        nestedAggBuilder.subAggregation(userNumberAggBuilder);
        //组装聚合查询条件
        SearchQuery searchQuery =
                new NativeSearchQueryBuilder().withIndices("houyi_qikan_article_dev")
                        .withTypes("info")
                        .withPageable(PageRequest.of(0, 1))
                        .addAggregation(nestedAggBuilder)
                        .build();
        //执行查询
        Aggregations aggregations = elasticsearchRestTemplate.query(searchQuery, new ResultsExtractor<Aggregations>() {
            @Override
            public Aggregations extract(SearchResponse response) {
                return response.getAggregations();
            }
        });
        ParsedNested parsedNested = (ParsedNested) aggregations.get("queryAuthorNum");
        ParsedStatsBucket bucketSum = parsedNested.getAggregations().get("bucketSum");
        System.out.println(bucketSum.getCount());
    }

    @Test
    void saveAll() {
        List<EsBean> list = Arrays.asList(new EsBean(1000, "张三", 18), new EsBean(1001, "lisi", 21), new EsBean(1002, "汪五",25));
        esMapper.saveAll(list);
    }
    @Test
    void findAll(){
        Iterator<EsBean> iterator = esMapper.findAll().iterator();
        ArrayList<EsBean> esBeans = Lists.newArrayList(iterator);
        for (int i = 0; i < esBeans.size(); i++) {
            System.out.println(esBeans.get(i).getId());
        }
    }
    @Test
    void selectDataById(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        SearchQuery build  =  nativeSearchQueryBuilder.withQuery(QueryBuilders.termQuery("id",1001))
                                    .withPreference("_primary_first")
                                    .withIndices("liuh_test3")
                                    .build();
        Map map = elasticsearchRestTemplate.query(build,searchResponse->{
            SearchHits hits = searchResponse.getHits();
            SearchHit[] hits1 = hits.getHits();
            return hits1[0].getSourceAsMap();
        });
        map.forEach((key,value)->{
            System.out.println(key + ":" + value);
        });
    }

    @Test
    void saveArticle() {
        ArticleBean first = new ArticleBean();
        first.setId(1010101l);
        List<AuthorAndUnitInfo> list1 = new ArrayList<>();
        AuthorAndUnitInfo info1 = new AuthorAndUnitInfo();
        info1.setAuthorId("2001");
        list1.add(info1);
        first.setAuthorAndUnitInfo(list1);

        ArticleBean second = new ArticleBean();
        second.setId(1011102l);
        List<AuthorAndUnitInfo> list2 = new ArrayList<>();
        AuthorAndUnitInfo info11 = new AuthorAndUnitInfo();
        info11.setAuthorId("2001");
        AuthorAndUnitInfo info22 = new AuthorAndUnitInfo();
        info22.setAuthorId("2001");
        AuthorAndUnitInfo info33 = new AuthorAndUnitInfo();
        info33.setAuthorId("2005");
        list2.add(info11);
        list2.add(info22);
        list2.add(info33);
        second.setAuthorAndUnitInfo(list2);

        ArticleBean third = new ArticleBean();
        third.setId(1011203l);
        List<AuthorAndUnitInfo> list3 = new ArrayList<>();
        AuthorAndUnitInfo info111 = new AuthorAndUnitInfo();
        info111.setAuthorId("2005");
        AuthorAndUnitInfo info222 = new AuthorAndUnitInfo();
        info222.setAuthorId("2006");
        AuthorAndUnitInfo info333 = new AuthorAndUnitInfo();
        info333.setAuthorId("2007");
        list3.add(info111);
        list3.add(info222);
        list3.add(info333);
        third.setAuthorAndUnitInfo(list3);
        List<ArticleBean> list = Arrays.asList(first,second,third);
        articleMapper.saveAll(list);
    }

    @Test
    void test1(){
        //查询条件设置
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = boolQuery();
        InnerHitBuilder innerHitBuilder = new InnerHitBuilder();
        innerHitBuilder.setSize(10000);
        boolQueryBuilder.must(QueryBuilders.nestedQuery("address",
                QueryBuilders.termQuery("address.city", "beijing"), ScoreMode.None).innerHit(innerHitBuilder));
        //检索信息
        SearchQuery build  =  nativeSearchQueryBuilder.withQuery(boolQueryBuilder)
                .withIndices("liuh_test6")
                .withFields("info")
                .build();
        //执行查询
        List<Map<String,Object>> results = elasticsearchRestTemplate.query(build, searchResponse->{
            SearchHits hits = searchResponse.getHits();
            SearchHit[] hits1 = hits.getHits();
            Map<String, SearchHits> innerHits = hits1[0].getInnerHits();
            Iterator<SearchHit> address1 = innerHits.get("address").iterator();
            List<Map<String,Object>> list = new ArrayList<>();
            while(address1.hasNext()){
                list.add(address1.next().getSourceAsMap());
            }
            return list;
        });
    }
}
