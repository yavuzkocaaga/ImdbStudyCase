package com.studycase.imdb.controller.payload;

import com.studycase.imdb.model.entity.MovieCrew;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDto implements Serializable {

    private String tconst;
    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private Integer isAdult;
    private String startYear;
    private String endYear;
    private Integer runtimeMinutes;
    private String genres;
    private List<MovieCrewDto> movieCrews;
}
