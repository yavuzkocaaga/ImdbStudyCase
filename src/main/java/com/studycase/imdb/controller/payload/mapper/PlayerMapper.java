package com.studycase.imdb.controller.payload.mapper;

import com.studycase.imdb.controller.payload.PlayerDto;
import com.studycase.imdb.model.entity.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {


    public PlayerDto asDto(Player player) {
        return PlayerDto.builder().ncost(player.getNcost()).primaryName(player.getPrimaryName()).build();
    }

    public Player asEntity(PlayerDto playerDto) {
        final Player player = new Player();
        player.setNcost(playerDto.getNcost());
        player.setPrimaryName(playerDto.getPrimaryName());
        player.setBirtyYear(playerDto.getBirtyYear());
        player.setPrimaryName(playerDto.getPrimaryName());
        player.setPrimaryProfession(playerDto.getPrimaryProfession());
        player.setKnownForTitles(playerDto.getKnownForTitles());
        return player;
    }

}
