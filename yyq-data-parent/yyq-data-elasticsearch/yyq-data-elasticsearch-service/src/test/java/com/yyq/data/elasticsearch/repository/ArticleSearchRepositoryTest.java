package com.yyq.data.elasticsearch.repository;

import com.yyq.data.elasticsearch.domain.Article;
import com.yyq.data.elasticsearch.domain.Author;
import com.yyq.data.elasticsearch.domain.Tutorial;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by yangyunqi on 2017/7/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleSearchRepositoryTest {

    @Autowired
    private ArticleSearchRepository articleSearchRepository;

    @Test
    public void testSaveArticleIndex(){
        Author author = new Author();
        author.setId(1L);
        author.setName("Ricky Young");
        author.setRemark("java developer");

        Tutorial tutorial = new Tutorial();
        tutorial.setId(1L);
        tutorial.setName("elastic search");

        Article article = new Article();
        article.setId(1L);
        article.setTitle("springboot integreate elasticsearch");
        article.setAbstracts("springboot integreate elasticsearch is very easy");
        article.setTutorial(tutorial);
        article.setAuthor(author);
        article.setContent("elasticsearch based on lucene,"
                + "spring-data-elastichsearch based on elaticsearch"
                + ",this tutorial tell you how to integrete springboot with spring-data-elasticsearch");
        article.setPostTime(new Date());
        article.setClickCount(1L);

        articleSearchRepository.save(article);
    }

    @Test
    public void testSearch(){
        String queryString = "springboot";//搜索关键字
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
        Iterable<Article> searchResult = articleSearchRepository.search(builder);
        for (Article aSearchResult : searchResult) {
            System.out.println(aSearchResult);
        }
    }

}