package com.yyq.data.neo4j.domain.actor;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by yunqiyang on 2017/3/2.
 */
@JsonIdentityInfo(generator = JSOGGenerator.class)//防止查询数据时引发递归访问效应
@NodeEntity
public class Actor {

    @GraphId
    private Long id;
    private String name;
    private int born;

    public Actor() {
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

    public int getBorn() {
        return born;
    }

    public void setBorn(int born) {
        this.born = born;
    }
}
