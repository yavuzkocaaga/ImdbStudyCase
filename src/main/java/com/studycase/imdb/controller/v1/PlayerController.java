package com.studycase.imdb.controller.v1;

import com.studycase.imdb.controller.payload.PlayerMoviesDto;
import com.studycase.imdb.controller.payload.message.UIMessage;
import com.studycase.imdb.controller.payload.request_response.PlayedTogetherRequest;
import com.studycase.imdb.controller.payload.request_response.PlayerMoviesRequest;
import com.studycase.imdb.controller.payload.request_response.RestResponse;
import com.studycase.imdb.service.PlayerService;
import com.studycase.imdb.util.ImdbEnums;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/player", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("/movies")
    public ResponseEntity<RestResponse<PlayerMoviesDto>> playerMovies(
            @RequestBody @Validated PlayerMoviesRequest playerMoviesRequest) {
        final PlayerMoviesDto playerMovies = playerService.getPlayerMovies(playerMoviesRequest.getPlayerName());

        if (playerMovies != null){
            return  ResponseEntity.ok()
                    .body(RestResponse.ofSuccess(playerMovies ,"200","SUCCESS"));
        }else{
            UIMessage uiMessage = new UIMessage("400", null, ImdbEnums.Severity.ERROR);
            return  ResponseEntity.ok()
                    .body(RestResponse.ofError(playerMovies ,uiMessage));
        }

    }

    @PostMapping("/played-together")
    public ResponseEntity<RestResponse<Boolean>> playedTogether(
            @RequestBody @Validated PlayedTogetherRequest playedTogetherRequest) {
        final Boolean playedTogether = playerService.playedTogether(playedTogetherRequest);


        if (playedTogether){
            return ResponseEntity.ok()
                    .body(RestResponse.ofSuccess(playedTogether,"200","success") );
        }else{
            UIMessage uiMessage = new UIMessage("400", null, ImdbEnums.Severity.ERROR);
            return  ResponseEntity.ok()
                    .body(RestResponse.ofError(playedTogether ,uiMessage));
        }


    }

}
