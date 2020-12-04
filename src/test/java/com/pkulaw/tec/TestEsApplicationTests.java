package com.pkulaw.tec;

import com.google.common.collect.Lists;
import com.pkulaw.tec.entity.po.EsBean;
import com.pkulaw.tec.mapper.EsMapper;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.*;

@SpringBootTest
class TestEsApplicationTests {

    @Autowired
    EsMapper esMapper;

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

}
