package com.studycase.imdb.model.repository;

import com.studycase.imdb.model.entity.MovieCrew;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieCrewRepository extends CrudRepository<MovieCrew, String> {

    List<MovieCrew> findByNconstAndTconst(String nconst,String tconst);

}
