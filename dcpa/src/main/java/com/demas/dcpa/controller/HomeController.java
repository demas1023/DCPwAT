package com.demas.dcpa.controller;

import com.demas.dcpa.data.dto.GameDTO;
import com.demas.dcpa.data.dto.PublicationDTO;
import com.demas.dcpa.service.ClientService;
import com.demas.dcpa.service.GameService;
import com.demas.dcpa.service.PublicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class HomeController {

    private final GameService gameService;
    private final PublicationService publicationService;

    public HomeController(GameService gameService, PublicationService publicationService) {
        this.gameService = gameService;
        this.publicationService = publicationService;
    }

    @GetMapping("/home")
    public String home(Model model){
        List<GameDTO> newGames = gameService.findAllGamesByDateRange(Date.valueOf(LocalDate.now().minusDays(7)), Date.valueOf(LocalDate.now()));
        List<PublicationDTO> newDevlogs = publicationService.findAllDevlogsBetweenDates(Date.valueOf(LocalDate.now().minusDays(7)), Date.valueOf(LocalDate.now()));
        model.addAttribute("newGames", newGames);
        model.addAttribute("newDevlogs", newDevlogs);
        return "home/home";
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/home";
    }

}
