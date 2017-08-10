package com.yyq.data.neo4j.web;

import com.google.gson.Gson;
import com.yyq.data.neo4j.DataNeo4jServiceApplication;
import com.yyq.data.neo4j.domain.Task;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

/**
 * Created by yangyunqi on 2017/8/10.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataNeo4jServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskControllerTest {

    @LocalServerPort
    private int port;

    private URL base;
    private Gson gson = new Gson();

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void saveTask() throws Exception {
        ResponseEntity<Task> test = this.restTemplate.getForEntity( this.base.toString() + "/测试任务", Task.class);
        log.info(gson.toJson(test.getBody()));
    }

    @Test
    public void getTask() throws Exception {
        Task task = new Task();
        task.setTaskName("测试任务");
        ResponseEntity<Task> test = this.restTemplate.postForEntity( this.base.toString() + "/task",task, Task.class);
        log.info(gson.toJson(test.getBody()));
    }

}