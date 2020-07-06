package com.studycase.imdb.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Data
@RedisHash("Movie")
public class Movie implements Serializable {

    /**
     * {
     * "tconst": "tt1798709",
     * "titleType": "movie",
     * "primaryTitle": "Her",
     * "originalTitle": "Her",
     * "isAdult": 0,
     * "startYear": 2013,
     * "endYear": "N",
     * "runtimeMinutes": 126,
     * "genres": "Drama,Romance,Sci-Fi"
     * }
     **/

    @Id
    @Indexed
    private String id;
    @Indexed
    private String tconst;
    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private Integer isAdult;
    private String startYear;
    private String endYear;
    private Integer runtimeMinutes;
    private String genres;

}
