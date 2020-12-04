package com.pkulaw.tec.service.impl;

import com.pkulaw.tec.entity.po.EsBean;
import com.pkulaw.tec.service.IndexOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by liuhai on 2020/11/28 22:04
 */
@Service
public class IndexOperateServiceImpl implements IndexOperateService {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Override
    public void createIndex() {
        elasticsearchRestTemplate.createIndex(EsBean.class);
        elasticsearchRestTemplate.putMapping(EsBean.class);
    }
}
