package com.studycase.imdb.model.repository;

import com.studycase.imdb.model.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, String> {

    Movie findByTconst(String tconst);

}
