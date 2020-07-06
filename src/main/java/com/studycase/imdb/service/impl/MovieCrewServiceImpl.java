package com.studycase.imdb.service.impl;


import com.studycase.imdb.controller.payload.MovieCrewDto;
import com.studycase.imdb.controller.payload.mapper.MovieCrewMapper;
import com.studycase.imdb.model.entity.MovieCrew;
import com.studycase.imdb.model.repository.MovieCrewRepository;
import com.studycase.imdb.service.MovieCrewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieCrewServiceImpl implements MovieCrewService {

    private final MovieCrewRepository movieCrewRepository;
    private final MovieCrewMapper movieCrewMapper;

    @Override
    public MovieCrew saveMoviesCrews(MovieCrewDto movieCrewDto) {
        final MovieCrew movieCrew = movieCrewMapper.asEntity(movieCrewDto);
        return movieCrewRepository.save(movieCrew);
    }

    @Override
    public List<MovieCrew> findByNconstAndTconst(String nconst,String tconst) {
        return movieCrewRepository.findByNconstAndTconst(nconst,tconst);
    }

}
