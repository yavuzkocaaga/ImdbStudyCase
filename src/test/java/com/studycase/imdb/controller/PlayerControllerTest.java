package com.studycase.imdb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.studycase.imdb.controller.payload.request_response.PlayedTogetherRequest;
import com.studycase.imdb.controller.v1.PlayerController;
import com.studycase.imdb.service.PlayerService;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(PowerMockRunner.class)
public class PlayerControllerTest {


    private static final String ADDRESS_POST_ENDPOINT = "/api/v1/player";


    private MockMvc mvc;

    private ObjectMapper objectMapper;


    @Mock
    private PlayerService playerService;

    @Before
    public void setUp() {

        objectMapper = new ObjectMapper();
        mvc = MockMvcBuilders
                .standaloneSetup(new PlayerController(playerService))
                .build();
    }



    @Test
    public void playedTogether() throws Exception {
       /* String playerOneName = "Robert Downey Jr.";
        String playerSecondName = "Chris Evans";
        mvc.perform(
                post(ADDRESS_POST_ENDPOINT + "/played-together", 1)
                        .accept(MediaType.APPLICATION_JSON)
                        .param("playerOneName", playerOneName)
                        .param("playerSecondName", playerSecondName))
                .andDo(print())
                .andExpect(status().isOk());

        //@formatter:on */
    }

}



