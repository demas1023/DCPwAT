package com.demas.dcpa.controller;

import com.demas.dcpa.data.dto.GameDTO;
import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.service.AchivementService;
import com.demas.dcpa.service.ClientService;
import com.demas.dcpa.service.GameService;
import com.demas.dcpa.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/{clientName}")
public class ClientController {

    private final ClientService clientService;
    private final GameService gameService;
    private final AchivementService achivementService;
    private final PublicationService publicationService;

    @Autowired
    public ClientController(ClientService clientService, GameService gameService, AchivementService achivementService, PublicationService publicationService) {
        this.clientService = clientService;
        this.gameService = gameService;
        this.achivementService = achivementService;
        this.publicationService = publicationService;
    }

    @GetMapping("/profile")
    public String profile(@PathVariable String clientName, Model model) {
        Client client = clientService.findClientByName(clientName);
        //TODO: ADD GAMES/ACHIEVEMENTS/PUBLICATIONS OWNED/COMPLETED/PUBLISHED BY THIS USER
        model.addAttribute("Client", client);
        model.addAttribute("clientName", clientName);
        return "client/profile";
    }

    @GetMapping("/games")
    public String games(@PathVariable String clientName, Model model) {
        Client client = clientService.findClientByName(clientName);
        List<GameDTO> clientGames = gameService.findAllGamesByClient(client);
        model.addAttribute("clientGames", clientGames);
        model.addAttribute("client", client);
        model.addAttribute("clientName", clientName);
        return "client/games";
    }


}
