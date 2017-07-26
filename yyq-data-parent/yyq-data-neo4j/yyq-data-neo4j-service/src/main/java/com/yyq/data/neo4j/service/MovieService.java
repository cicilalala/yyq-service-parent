package com.yyq.data.neo4j.service;

import com.yyq.data.neo4j.domain.actor.Actor;
import com.yyq.data.neo4j.domain.actor.Movie;
import com.yyq.data.neo4j.domain.actor.Role;
import com.yyq.data.neo4j.repository.actor.ActorRepository;
import com.yyq.data.neo4j.repository.actor.MovieRepository;
import com.yyq.data.neo4j.repository.actor.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yangyunqi on 2017/7/26.
 */
@Slf4j
@Service
public class MovieService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void initData() {

        Movie matrix1 = new Movie();
        matrix1.setTitle("The Matrix");
        matrix1.setYear("1999-03-31");

        Movie matrix2 = new Movie();
        matrix2.setTitle("The Matrix Reload");
        matrix2.setYear("2003-05-07");

        Movie matrix3 = new Movie();
        matrix3.setTitle("The Matrix Revolutions");
        matrix3.setYear("2003-10-27");

        Actor keanu = new Actor();
        keanu.setName("Keanu Reeves");

        Actor laurence = new Actor();
        laurence.setName("Laurence Fishburne");

        Actor carrieanne = new Actor();
        carrieanne.setName("Carrie-Anne Moss");

        matrix1.addRole(keanu, "Neo");
        matrix1.addRole(laurence, "Morpheus");
        matrix1.addRole(carrieanne, "Trinity");
        movieRepository.save(matrix1);

        matrix2.addRole(keanu, "Neo");
        matrix2.addRole(laurence, "Morpheus");
        matrix2.addRole(carrieanne, "Trinity");
        movieRepository.save(matrix2);

        matrix3.addRole(keanu, "Neo");
        matrix3.addRole(laurence, "Morpheus");
        matrix3.addRole(carrieanne, "Trinity");
        movieRepository.save(matrix3);
    }

    public void findByTitle() throws Exception {

        Movie movie = movieRepository.findByTitle("The Matrix");
        Assert.assertNotNull(movie);
        log.info("=====movie=====:{}, {}", movie.getTitle(), movie.getYear());
        for (Role role : movie.getRoles()) {
            log.info("=====actor:{}, role:{}", role.getActor().getName(), role.getRole());
        }
    }

}
