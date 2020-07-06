package com.studycase.imdb.controller.payload.request_response;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayedTogetherRequest implements Serializable {

    @NonNull
    private String playerOneName;

    @NonNull
    private String playerSecondName;


}
