package com.studycase.imdb.controller.payload;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerDto implements Serializable {

    public String ncost;
    public String primaryName;
    public String birtyYear;
    public String deathYear;
    public String primaryProfession[];
    public String knownForTitles[];
}
