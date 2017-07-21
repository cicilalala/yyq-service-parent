package com.yyq.data.elasticsearch.repository;

import com.yyq.data.elasticsearch.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by yangyunqi on 2017/7/20.
 */
public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {

}
