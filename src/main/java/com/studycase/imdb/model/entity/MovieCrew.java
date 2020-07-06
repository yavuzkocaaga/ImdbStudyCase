package com.studycase.imdb.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Data
@RedisHash("MovieCrew")
public class MovieCrew implements Serializable {

    /**
     * {
     * "tconst": "tt1798709",
     * "ordering": "3",
     * "nconst": "nm0005069",
     * "category": "director",
     * "job": "N",
     * "characters": "N"
     * }
     **/

    @Id
    @Indexed
    private String id;
    private Integer ordering;
    @Indexed
    private String tconst;
    @Indexed
    private String nconst;
    private String category;
    private String job;
    private String characters;

}
