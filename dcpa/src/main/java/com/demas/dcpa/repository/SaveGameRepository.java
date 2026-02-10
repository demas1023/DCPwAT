package com.demas.dcpa.repository;

import com.demas.dcpa.data.entity.Game;
import com.demas.dcpa.data.entity.GameSave;

import java.util.List;

public interface SaveGameRepository {

    boolean saveGame(GameSave save);
    boolean removeGame(GameSave save);

    List<GameSave> getSaveGamesByGame(Game game);
    List<GameSave> getSaveGamesByClient(String client);


}
