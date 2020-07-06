package com.studycase.imdb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.HttpHeaders;
import com.studycase.imdb.controller.payload.PlayerMoviesDto;
import com.studycase.imdb.controller.payload.request_response.PlayedTogetherRequest;
import com.studycase.imdb.controller.payload.request_response.PlayerMoviesRequest;
import com.studycase.imdb.controller.v1.PlayerController;
import com.studycase.imdb.service.PlayerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
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
    public void testPlayerMovies() throws Exception {
        PlayerMoviesRequest playerMoviesRequest = new PlayerMoviesRequest("Robert Downey Jr.");//whichever data your entity class have
        PlayerMoviesDto playerMoviesDto = new PlayerMoviesDto();
        Mockito.when(playerService.getPlayerMovies(playerMoviesRequest.getPlayerName())).thenReturn(playerMoviesDto);

        mvc.perform(MockMvcRequestBuilders.post(ADDRESS_POST_ENDPOINT + "/movies")
                .content(asJsonString(playerMoviesRequest))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testPlayedTogether() throws Exception {
        PlayedTogetherRequest playedTogetherRequest = new PlayedTogetherRequest("Robert Downey Jr.","Chris Evans");//whichever data your entity class have

        Mockito.when(playerService.playedTogether(playedTogetherRequest)).thenReturn(true);

        mvc.perform(MockMvcRequestBuilders.post(ADDRESS_POST_ENDPOINT + "/played-together")
                .content(asJsonString(playedTogetherRequest))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}



