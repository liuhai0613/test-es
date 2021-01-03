package com.pkulaw.tec.mapper;

import com.pkulaw.tec.entity.po.ArticleBean;
import com.pkulaw.tec.entity.po.ArticleTest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

/**
 * Created by liuhai on 2020/12/31 20:07
 */
@Service
public interface ArticleAliasMapper extends ElasticsearchRepository<ArticleTest,Long> {

}
