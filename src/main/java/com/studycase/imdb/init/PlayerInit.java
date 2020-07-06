package com.studycase.imdb.init;

import com.studycase.imdb.controller.payload.MovieCrewDto;
import com.studycase.imdb.controller.payload.MovieDto;
import com.studycase.imdb.controller.payload.PlayerDto;
import com.studycase.imdb.service.MovieCrewService;
import com.studycase.imdb.service.MovieService;
import com.studycase.imdb.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlayerInit {

    private final PlayerService playerService;
    private final MovieService movieService;
    private final MovieCrewService movieCrewService;

    public void insertToRedis(List<PlayerDto> playerDtoList) {
        playerDtoList.forEach(playerDto -> {
            playerService.savePlayer(playerDto);
        });

    }

    public void insertMovieToRedis(List<MovieDto> movieDtoList) {
        movieDtoList.forEach(movieDto -> {
            movieService.saveMovies(movieDto);
        });
    }


    public void insertMovieCrewToRedis(List<MovieCrewDto> movieCrewList) {
        movieCrewList.forEach(movieDto -> {
            movieCrewService.saveMoviesCrews(movieDto);
        });
    }

}
