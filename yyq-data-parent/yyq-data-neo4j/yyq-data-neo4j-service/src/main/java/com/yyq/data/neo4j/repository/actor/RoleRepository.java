package com.yyq.data.neo4j.repository.actor;

import com.yyq.data.neo4j.domain.actor.Role;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created by yangyunqi on 2017/7/26.
 */
public interface RoleRepository extends Neo4jRepository<Role, Long> {
}
