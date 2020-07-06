package com.studycase.imdb.config;

import com.studycase.imdb.controller.payload.MovieCrewDto;
import com.studycase.imdb.controller.payload.MovieDto;
import com.studycase.imdb.controller.payload.PlayerDto;
import com.studycase.imdb.init.PlayerInit;
import com.studycase.imdb.util.FileReader;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class StartupApplicationRunner implements ApplicationRunner {

    private final PlayerInit playerInit;
    private final FileReader fileReader;
    private final Jedis jedis;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        jedis.flushDB();
        final List<PlayerDto> playerDtos = fileReader.getPlayersFromJson();
        playerInit.insertToRedis(playerDtos);

        final List<MovieDto> movieDtos = fileReader.getMoviesFromJson();
        playerInit.insertMovieToRedis(movieDtos);

        final List<MovieCrewDto> movieCrewDtos = fileReader.getMovieCrewFromJson();
        playerInit.insertMovieCrewToRedis(movieCrewDtos);


    }
}
