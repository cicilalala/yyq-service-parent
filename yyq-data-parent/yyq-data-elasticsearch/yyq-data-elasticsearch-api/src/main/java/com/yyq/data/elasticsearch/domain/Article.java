package com.yyq.data.elasticsearch.domain;

import com.yyq.base.api.model.BaseModel;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * Created by yangyunqi on 2017/7/20.
 */
@Document(indexName="dataelasticsearch", type="article", indexStoreType="fs", shards=5, replicas=1, refreshInterval="-1")
public class Article extends BaseModel<Article> {

    private static final long serialVersionUID = 2016278528606691829L;
    private Long id;
    private String title;
    private String abstracts;
    private String content;
    private Date postTime;
    private Long clickCount;
    private Author author;
    private Tutorial tutorial;

    public Article() {
    }

    public Article(Long id, String title, String abstracts, String content, Date postTime, Long clickCount, Author author, Tutorial tutorial) {
        this.id = id;
        this.title = title;
        this.abstracts = abstracts;
        this.content = content;
        this.postTime = postTime;
        this.clickCount = clickCount;
        this.author = author;
        this.tutorial = tutorial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Tutorial getTutorial() {
        return tutorial;
    }

    public void setTutorial(Tutorial tutorial) {
        this.tutorial = tutorial;
    }
}
