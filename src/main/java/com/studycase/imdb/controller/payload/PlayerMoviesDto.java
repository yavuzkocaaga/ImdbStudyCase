package com.studycase.imdb.controller.payload;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerMoviesDto implements Serializable {

    private List<MovieDto> playerMovies;


}
