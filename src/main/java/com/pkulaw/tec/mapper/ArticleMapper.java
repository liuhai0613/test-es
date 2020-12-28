package com.pkulaw.tec.mapper;

import com.pkulaw.tec.entity.po.ArticleBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

/**
 * Created by liuhai on 2020/12/28 9:31
 */
@Service
public interface ArticleMapper extends ElasticsearchRepository<ArticleBean,Long> {

}
