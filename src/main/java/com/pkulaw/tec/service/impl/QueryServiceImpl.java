package com.pkulaw.tec.service.impl;

import com.pkulaw.tec.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by liuhai on 2020/11/28 19:11
 */
@Service
public class QueryServiceImpl implements QueryService {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public String esQueryTest1() {
        return null;
    }
}
