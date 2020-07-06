package com.studycase.imdb.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studycase.imdb.controller.payload.MovieCrewDto;
import com.studycase.imdb.controller.payload.MovieDto;
import com.studycase.imdb.controller.payload.PlayerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class FileReader {

    @Autowired
    ResourceLoader resourceLoader;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<PlayerDto> getPlayersFromJson() throws Exception {
        final String data = getResourceAsString("data/player.json");
        return Arrays.asList(objectMapper.readValue(data, PlayerDto[].class));
    }

    public List<MovieDto> getMoviesFromJson() throws Exception {
        final String data = getResourceAsString("data/movie.json");
        return Arrays.asList(objectMapper.readValue(data, MovieDto[].class));
    }

    public List<MovieCrewDto> getMovieCrewFromJson() throws Exception {
        final String data = getResourceAsString("data/movieCrew.json");
        return Arrays.asList(objectMapper.readValue(data, MovieCrewDto[].class));
    }


    private String getResourceAsString(String filePath) throws Exception {
        final Resource resource = resourceLoader.getResource("classpath:" + filePath);
        final InputStream inputStream = resource.getInputStream();

        try {
            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            return new String(bdata, StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }


}
