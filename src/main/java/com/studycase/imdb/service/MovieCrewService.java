package com.studycase.imdb.service;

import com.studycase.imdb.controller.payload.MovieCrewDto;
import com.studycase.imdb.model.entity.MovieCrew;

import java.util.List;

public interface MovieCrewService {

    MovieCrew saveMoviesCrews(MovieCrewDto movieCrewDto);

    List<MovieCrew> findByNconstAndTconst(String nconst,String tconst);
}
