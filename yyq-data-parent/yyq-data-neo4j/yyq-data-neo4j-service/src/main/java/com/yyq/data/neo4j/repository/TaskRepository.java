package com.yyq.data.neo4j.repository;

import com.yyq.data.neo4j.domain.Task;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by yangyunqi on 2017/8/10.
 */
@Repository
public interface TaskRepository extends Neo4jRepository<Task, Long> {

    Task findByTaskName(@Param("taskName") String taskName);

    @Query("MATCH (t:Task) WHERE t.taskName =~ ('(?i).*'+{taskName}+'.*') RETURN t")
    Collection<Task> findByNameContaining(@Param("taskName") String taskName);
}
