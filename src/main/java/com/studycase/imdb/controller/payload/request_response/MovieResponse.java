package com.studycase.imdb.controller.payload.request_response;


import com.studycase.imdb.controller.payload.MovieDto;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse implements Serializable {
    private List<MovieDto> movieDtos;

}
