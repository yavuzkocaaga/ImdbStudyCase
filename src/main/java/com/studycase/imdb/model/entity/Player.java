package com.studycase.imdb.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Player")
public class Player implements Serializable {

    @Id
    private String id;
    @Indexed
    public String ncost;
    @Indexed
    public String primaryName;
    public String birtyYear;
    public String deathYear;
    public String primaryProfession[];
    public String knownForTitles[];
}
