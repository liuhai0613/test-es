package com.pkulaw.tec.service.impl;

import com.pkulaw.tec.service.QueryService;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by liuhai on 2020/11/28 19:11
 */
@Service
public class QueryServiceImpl implements QueryService {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public String esQueryTest1() {
        List<String> fieldList = new ArrayList<>();
        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.termQuery("name","zhangsan"))
                .withIndices("liuh_test5")
                .build();
        Map<String,Object> map = elasticsearchRestTemplate.query(build, searchResponse -> {
            return null;
        });
        return null;
    }

    public Object esQueryTest2(String... resultParam) {
        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.termQuery("name","zhangsan"))
                .withIndices("liuh_test5").withFields(resultParam)
                .build();
        List<Map<String,Object>> map = elasticsearchRestTemplate.query(build, searchResponse -> {
            SearchHits hits = searchResponse.getHits();
            List<Map<String, Object>> result = Arrays.stream(hits.getHits()).map(hit->{
                return hit.getSourceAsMap();
            }).collect(Collectors.toList());;
            return result;
        });
        return map;
    }
}
