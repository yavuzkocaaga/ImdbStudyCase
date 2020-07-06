package com.studycase.imdb.service;

import com.studycase.imdb.controller.payload.MovieDto;
import com.studycase.imdb.controller.payload.request_response.MovieRequest;
import com.studycase.imdb.model.entity.Movie;

import java.util.List;

public interface MovieService {
    List<MovieDto> getMovies(MovieRequest request);

    Movie saveMovies(MovieDto movieDto);

    Movie findByTconst(String tconst);
}
