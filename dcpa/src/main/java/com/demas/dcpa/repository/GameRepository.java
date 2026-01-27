package com.demas.dcpa.repository;

import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.data.entity.Game;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository {

    boolean addGame(Game game);
    boolean removeGame(Game game);
    boolean updateGame(Game game);

    Optional<Game> findGameById(int id);
    Optional<Game> findGameByName(String name);

    List<Game> findAllGames();
    List<Game> findAllGamesByName(String name);
}
