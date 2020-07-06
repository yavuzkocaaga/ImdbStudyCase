package com.studycase.imdb.controller.payload.mapper;

import com.studycase.imdb.controller.payload.MovieDto;
import com.studycase.imdb.model.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieDto asDto(Movie movie) {
        return MovieDto.builder().tconst(movie.getTconst()).titleType(movie.getTitleType())
                .primaryTitle(movie.getPrimaryTitle()).originalTitle(movie.getOriginalTitle())
                .isAdult(movie.getIsAdult()).startYear(movie.getStartYear()).endYear(movie.getEndYear())
                .runtimeMinutes(movie.getRuntimeMinutes()).genres(movie.getGenres()).build();
    }

    public Movie asEntity(MovieDto movieDto) {
        final Movie movie = new Movie();
        movie.setTconst(movieDto.getTconst());
        movie.setTitleType(movieDto.getTitleType());
        movie.setPrimaryTitle(movieDto.getPrimaryTitle());
        movie.setOriginalTitle(movieDto.getOriginalTitle());
        movie.setIsAdult(movieDto.getIsAdult());
        movie.setStartYear(movieDto.getStartYear());
        movie.setEndYear(movieDto.getEndYear());
        movie.setRuntimeMinutes(movieDto.getRuntimeMinutes());
        movie.setGenres(movieDto.getGenres());
        return movie;
    }
}
