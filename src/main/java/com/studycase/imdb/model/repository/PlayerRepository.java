package com.studycase.imdb.model.repository;

import com.studycase.imdb.model.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, String> {


    Player findByPrimaryName(String primaryName);


}
