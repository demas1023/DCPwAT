package com.demas.dcpa.repository;

import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.data.entity.ClientGame;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientGameRepository {

    List<ClientGame> getClientGamesByClient(Client client);

    boolean addClientGame(ClientGame clientGame);
    boolean removeClientGame(ClientGame clientGame);
}
