package com.yyq.data.elasticsearch.domain;

import com.yyq.base.api.model.BaseModel;

/**
 * Created by yangyunqi on 2017/7/20.
 */
public class Tutorial extends BaseModel<Tutorial> {

    private static final long serialVersionUID = 891758194641964754L;

    private Long id;
    private String name;

    public Tutorial() {
    }

    public Tutorial(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
