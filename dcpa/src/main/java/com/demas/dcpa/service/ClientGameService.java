package com.demas.dcpa.service;

import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.data.entity.ClientGame;
import com.demas.dcpa.data.entity.Game;
import com.demas.dcpa.repository.ClientGameRepository;
import jakarta.annotation.PreDestroy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientGameService {

    private final ClientGameRepository clientGameRepository;

    public ClientGameService(ClientGameRepository clientGameRepository) {
        this.clientGameRepository = clientGameRepository;
    }

    public List<Game> getGamesByClient(Client client) {
        return clientGameRepository.getClientGamesByClient(client).stream()
                .map(ClientGame::getGame)
                .collect(Collectors.toList());
    }

    public List<Client> getClientsByGame(Game game) {
        return clientGameRepository.getClientGameByGame(game).stream()
                .map(ClientGame::getClient)
                .collect(Collectors.toList());
    }

    public boolean addGameToClient(Client client, Game game) {
        return clientGameRepository.addClientGame(new ClientGame(client, game));
    }

    public boolean removeGameFromClient(Client client, Game game) {
        return clientGameRepository.removeClientGame(new ClientGame(client, game));
    }

    @PreAuthorize("hasRole('DEVELOPER')")
    public boolean uploadGameByDeveloper(Client client, Game game) {
        return clientGameRepository.addClientGame(new ClientGame(client, game, client.getRol()                                                         ));
    }

    @PreAuthorize("hasRole('DEVELOPER')")
    public boolean removeGameByDeveloper(Client client, Game game) {
        return clientGameRepository.removeClientGame(new ClientGame(client, game, client.getRol()));
    }
}
