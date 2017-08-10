package com.yyq.data.neo4j.web;

import com.yyq.data.neo4j.domain.Task;
import com.yyq.data.neo4j.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yangyunqi on 2017/8/10.
 */
@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @RequestMapping(value = "{name}", method = RequestMethod.POST)
    public Task getTask(@PathVariable String name) {
        return taskService.getTask(name);
    }
}
