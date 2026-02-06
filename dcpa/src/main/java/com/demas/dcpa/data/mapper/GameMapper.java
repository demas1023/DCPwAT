package com.demas.dcpa.data.mapper;

import com.demas.dcpa.data.dto.GameDTO;
import com.demas.dcpa.data.entity.Game;

public class GameMapper {
    public static GameDTO getGameDTO(Game game) {
        return new GameDTO(game.getName(), game.getDescription(), game.getImage(), game.getAddedDate());
    }

    public static Game getGame(GameDTO gameDTO) {
        return new Game(gameDTO.getTitle(), gameDTO.getDescription(), gameDTO.getImage(), gameDTO.getDateAdded());
    }
}
