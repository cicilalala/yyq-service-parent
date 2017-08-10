package com.yyq.data.neo4j.service;

import com.yyq.data.neo4j.domain.Task;
import com.yyq.data.neo4j.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangyunqi on 2017/8/10.
 */
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTask(String name) {
        return taskRepository.findByTaskName(name);
    }
}
