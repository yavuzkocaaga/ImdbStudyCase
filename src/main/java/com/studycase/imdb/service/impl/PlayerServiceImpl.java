package com.studycase.imdb.service.impl;

import com.studycase.imdb.controller.payload.MovieCrewDto;
import com.studycase.imdb.controller.payload.MovieDto;
import com.studycase.imdb.controller.payload.PlayerDto;
import com.studycase.imdb.controller.payload.PlayerMoviesDto;
import com.studycase.imdb.controller.payload.mapper.MovieCrewMapper;
import com.studycase.imdb.controller.payload.mapper.MovieMapper;
import com.studycase.imdb.controller.payload.mapper.PlayerMapper;
import com.studycase.imdb.controller.payload.request_response.PlayedTogetherRequest;
import com.studycase.imdb.exception.BusinessException;
import com.studycase.imdb.model.entity.Movie;
import com.studycase.imdb.model.entity.MovieCrew;
import com.studycase.imdb.model.entity.Player;
import com.studycase.imdb.model.repository.PlayerRepository;
import com.studycase.imdb.service.MovieCrewService;
import com.studycase.imdb.service.MovieService;
import com.studycase.imdb.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final MovieService movieService;
    private final MovieMapper movieMapper;
    private final MovieCrewMapper movieCrewMapper;
    private final MovieCrewService movieCrewService;
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;


    @Autowired
    private MessageSource messageSource;


    @Override
    public PlayerMoviesDto getPlayerMovies(String playerName) {

        final List<MovieDto> playerMovies = new ArrayList<>();

        final Player playerEntity = playerRepository.findByPrimaryName(playerName);

        if (ObjectUtils.isEmpty(playerEntity)) {
            throw new BusinessException(messageSource.getMessage("com.studycase.common.not.found",null, Locale.getDefault()));


        }

        final List<String> movieTconsts = Arrays.asList(playerEntity.getKnownForTitles());

        movieTconsts.forEach(tconst -> {

            final Movie movie = movieService.findByTconst(tconst);
            if (!ObjectUtils.isEmpty(movie)) {

                final List<MovieCrew> movieCrewList = movieCrewService.findByNconstAndTconst(playerEntity.getNcost(),tconst);

                final MovieDto movieDto = movieMapper.asDto(movie);
                if (movieDto.getMovieCrews() == null) {
                    movieDto.setMovieCrews(new ArrayList<>());
                }
                for (MovieCrew movieCrew : movieCrewList) {
                    final MovieCrewDto movieCrewDto = movieCrewMapper.asDto(movieCrew);
                    movieDto.getMovieCrews().add(movieCrewDto);
                }

                playerMovies.add(movieDto);

            }

        });

        return PlayerMoviesDto.builder().playerMovies(playerMovies).build();
    }


    @Override
    public Boolean playedTogether(PlayedTogetherRequest request) {

        final String playerOne = request.getPlayerOneName();
        final String playerSecond = request.getPlayerSecondName();

        final Player playerOneEntity = playerRepository.findByPrimaryName(playerOne);
        final Player playerSecondEntity = playerRepository.findByPrimaryName(playerSecond);


        if (ObjectUtils.isEmpty(playerOneEntity) || ObjectUtils.isEmpty(playerSecondEntity)) {
            throw new BusinessException("com.studycase.common.not.found");
        }

        final List<String> playerSecondTitles = Arrays.asList(playerSecondEntity.getKnownForTitles());
        final List<String> playerOneTitles = Arrays.asList(playerOneEntity.getKnownForTitles());

        final Set<String> result = playerOneTitles.stream()
                .distinct()
                .filter(playerSecondTitles::contains)
                .collect(Collectors.toSet());

        return result != null;

    }

    @Override
    public Player savePlayer(PlayerDto playerDto) {
        final Player player = playerMapper.asEntity(playerDto);
        return playerRepository.save(player);
    }
}
