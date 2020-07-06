package com.studycase.imdb.controller.payload.request_response;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerMoviesRequest implements Serializable {

    @NonNull
    private String playerName;


}
