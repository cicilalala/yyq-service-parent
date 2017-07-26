package com.yyq.data.neo4j.repository.actor;

import com.yyq.data.neo4j.domain.actor.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by yunqiyang on 2017/3/2.
 */
public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    Movie findByTitle(@Param("title") String title);
}
