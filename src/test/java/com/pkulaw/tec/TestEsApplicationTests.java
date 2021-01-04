package com.pkulaw.tec;

import com.google.common.collect.Lists;
import com.pkulaw.tec.entity.po.ArticleBean;
import com.pkulaw.tec.entity.po.EsBean;
import com.pkulaw.tec.entity.po.nested.AuthorAndUnitInfo;
import com.pkulaw.tec.mapper.ArticleMapper;
import com.pkulaw.tec.mapper.EsMapper;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.*;

@SpringBootTest
class TestEsApplicationTests {

    @Autowired
    EsMapper esMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

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
        first.setId(1010l);
        List<AuthorAndUnitInfo> list1 = new ArrayList<>();
        AuthorAndUnitInfo info1 = new AuthorAndUnitInfo();
        info1.setAuthorId("2001");
        AuthorAndUnitInfo info2 = new AuthorAndUnitInfo();
        info2.setAuthorId("2002");
        AuthorAndUnitInfo info3 = new AuthorAndUnitInfo();
        info3.setAuthorId("2003");
        list1.add(info1);
        list1.add(info2);
        list1.add(info3);
        first.setAuthorAndUnitInfo(list1);

        ArticleBean second = new ArticleBean();
        second.setId(1011l);
        List<AuthorAndUnitInfo> list2 = new ArrayList<>();
        AuthorAndUnitInfo info11 = new AuthorAndUnitInfo();
        info11.setAuthorId("2001");
        AuthorAndUnitInfo info22 = new AuthorAndUnitInfo();
        info22.setAuthorId("2004");
        AuthorAndUnitInfo info33 = new AuthorAndUnitInfo();
        info33.setAuthorId("2005");
        list2.add(info11);
        list2.add(info22);
        list2.add(info33);
        second.setAuthorAndUnitInfo(list2);

        ArticleBean third = new ArticleBean();
        third.setId(1012l);
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

}
