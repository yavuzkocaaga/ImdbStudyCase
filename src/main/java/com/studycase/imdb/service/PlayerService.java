package com.studycase.imdb.service;

import com.studycase.imdb.controller.payload.PlayerDto;
import com.studycase.imdb.controller.payload.PlayerMoviesDto;
import com.studycase.imdb.controller.payload.request_response.PlayedTogetherRequest;
import com.studycase.imdb.controller.payload.request_response.PlayerMoviesRequest;
import com.studycase.imdb.model.entity.Player;

public interface PlayerService {

    PlayerMoviesDto getPlayerMovies(String playerName);

    Boolean playedTogether(PlayedTogetherRequest request);

    Player savePlayer(PlayerDto playerDto);


}
