package com.yyq.data.neo4j.domain;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by yangyunqi on 2017/8/10.
 */
@NodeEntity
public class Task {

    private Long id;

    private String taskName;

    public Task() {
    }

    public Task(Long id, String taskName) {
        this.id = id;
        this.taskName = taskName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
