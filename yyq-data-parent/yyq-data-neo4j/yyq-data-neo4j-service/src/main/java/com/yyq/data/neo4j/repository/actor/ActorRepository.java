package com.yyq.data.neo4j.repository.actor;

import com.yyq.data.neo4j.domain.actor.Actor;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created by yangyunqi on 2017/3/13.
 */
public interface ActorRepository extends Neo4jRepository<Actor, Long> {
}
