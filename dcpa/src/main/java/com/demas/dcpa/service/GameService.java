package com.demas.dcpa.service;

import com.demas.dcpa.data.dto.GameDTO;
import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.data.entity.Game;
import com.demas.dcpa.data.mapper.GameMapper;
import com.demas.dcpa.repository.ClientGameRepository;
import com.demas.dcpa.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final ClientGameRepository clientGameRepository;

    public GameService(final GameRepository gameRepository, final ClientGameRepository clientGameRepository) {
        this.gameRepository = gameRepository;
        this.clientGameRepository = clientGameRepository;
    }

    public List<GameDTO> findAllGames() {
        return gameRepository.findAllGames().stream()
                .map(GameMapper::getGameDTO)
                .collect(Collectors.toList());
    }

    public List<GameDTO> findAllGamesByName(String name) {
        return gameRepository.findAllGamesByName(name).stream()
                .map(GameMapper::getGameDTO)
                .collect(Collectors.toList());
    }

    public GameDTO findGameById(int id) {
        Optional<Game> gameOpt =  gameRepository.findGameById(id);
        if (gameOpt.isPresent()) {
            return GameMapper.getGameDTO(gameOpt.get());
        } else {
            throw new RuntimeException("Game not found");
        }
    }

    public GameDTO findGameByName(String name) {
        Optional<Game> gameOpt =  gameRepository.findGameByName(name);
        if (gameOpt.isPresent()) {
            return GameMapper.getGameDTO(gameOpt.get());
        } else {
            throw new RuntimeException("Game not found");
        }
    }

    public boolean addGame(GameDTO game) { return gameRepository.addGame(GameMapper.getGame(game)); }

    public boolean removeGame(GameDTO game) { return gameRepository.removeGame(GameMapper.getGame(game)); }

    public boolean updateGame(GameDTO game) {
        return gameRepository.updateGame(GameMapper.getGame(game));
    }

    public List<GameDTO> findAllGamesByClient(Client client) {
        return clientGameRepository.getClientGamesByClient(client).stream()
                .map(clientGame -> GameMapper.getGameDTO(clientGame.getGame()))
                .collect(Collectors.toList());
    }
}
