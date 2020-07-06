package com.studycase.imdb.controller.payload.mapper;

import com.studycase.imdb.controller.payload.MovieCrewDto;
import com.studycase.imdb.model.entity.MovieCrew;
import org.springframework.stereotype.Component;

@Component
public class MovieCrewMapper {

    public MovieCrewDto asDto(MovieCrew movieCrew) {
        return MovieCrewDto.builder().tconst(movieCrew.getTconst()).category(movieCrew.getCategory())
                .job(movieCrew.getJob()).characters(movieCrew.getCharacters())
                .ordering(movieCrew.getOrdering()).nconst(movieCrew.getNconst()).build();
    }

    public MovieCrew asEntity(MovieCrewDto movieCrewDto) {
        final MovieCrew movieCrew = new MovieCrew();
        movieCrew.setCategory(movieCrewDto.getCategory());
        movieCrew.setCharacters(movieCrewDto.getCharacters());
        movieCrew.setJob(movieCrewDto.getJob());
        movieCrew.setOrdering(movieCrewDto.getOrdering());
        movieCrew.setNconst(movieCrewDto.getNconst());
        movieCrew.setTconst(movieCrewDto.getTconst());
        return movieCrew;
    }
}
