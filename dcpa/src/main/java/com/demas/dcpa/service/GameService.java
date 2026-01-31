package com.demas.dcpa.service;

import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.data.entity.Game;
import com.demas.dcpa.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(final GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findAllGames() {
        return gameRepository.findAllGames();
    }

    public List<Game> findAllGamesByName(String name) {
        return gameRepository.findAllGamesByName(name);
    }

    public Game findGameById(int id) {
        Optional<Game> gameOpt =  gameRepository.findGameById(id);
        if (gameOpt.isPresent()) {
            return gameOpt.get();
        } else {
            throw new RuntimeException("Game not found");
        }
    }

    public Game findGameByName(String name) {
        Optional<Game> gameOpt =  gameRepository.findGameByName(name);
        if (gameOpt.isPresent()) {
            return gameOpt.get();
        } else {
            throw new RuntimeException("Game not found");
        }
    }

    public boolean addGame(Game game) {
        return gameRepository.addGame(game);
    }

    public boolean removeGame(Game game) {
        return gameRepository.removeGame(game);
    }

    public boolean updateGame(Game game) {
        return gameRepository.updateGame(game);
    }

}
