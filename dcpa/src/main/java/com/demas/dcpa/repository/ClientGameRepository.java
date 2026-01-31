package com.demas.dcpa.repository;

import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.data.entity.ClientGame;
import com.demas.dcpa.data.entity.Game;
import com.demas.dcpa.data.rol.ClientRoles;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientGameRepository {

    List<ClientGame> getClientGamesByClient(Client client); //games owned by the client
    List<ClientGame> getClientGameByGame(Game game); //amount of clients that own a game

    boolean addClientGame(ClientGame clientGame);
    boolean removeClientGame(ClientGame clientGame);
}
