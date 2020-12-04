package com.pkulaw.tec.mapper;

import com.pkulaw.tec.entity.po.EsBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

@Service
public interface EsMapper extends ElasticsearchRepository<EsBean,Integer> {

}