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

    public List<Game> findAllGamesByClient(Client client) {
        Optional<Game> gameOpt = gameRepository.
    }

}
