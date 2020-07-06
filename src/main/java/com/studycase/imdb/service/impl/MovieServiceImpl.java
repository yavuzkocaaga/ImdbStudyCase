package com.studycase.imdb.service.impl;


import com.studycase.imdb.controller.payload.MovieDto;
import com.studycase.imdb.controller.payload.mapper.MovieMapper;
import com.studycase.imdb.controller.payload.request_response.MovieRequest;
import com.studycase.imdb.model.entity.Movie;
import com.studycase.imdb.model.repository.MovieRepository;
import com.studycase.imdb.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDto> getMovies(MovieRequest request) {
        return null;
    }

    @Override
    public Movie saveMovies(MovieDto movieDto) {
        final Movie movie = movieMapper.asEntity(movieDto);
        return movieRepository.save(movie);
    }

    @Override
    public Movie findByTconst(String tconst) {
        return movieRepository.findByTconst(tconst);
    }

}
