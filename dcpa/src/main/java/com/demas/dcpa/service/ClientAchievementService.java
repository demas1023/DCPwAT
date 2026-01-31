package com.demas.dcpa.service;

import com.demas.dcpa.data.entity.Achievement;
import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.data.entity.ClientAchievement;
import com.demas.dcpa.repository.ClientAchievementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientAchievementService {

    private final ClientAchievementRepository clientAchievementRepository;

    public ClientAchievementService(ClientAchievementRepository clientAchievementRepository) {
        this.clientAchievementRepository = clientAchievementRepository;
    }

    public List<Achievement> getAchievementsByClient(Client client) {
        return clientAchievementRepository.findAllClientAchievementsByClient(client).stream()
                .map(ClientAchievement::getAchievement)
                .collect(Collectors.toList());
    }

    public List<Client> getClientsByAchievement(Achievement achievement) {
        return clientAchievementRepository.findAllClientAchievementsByAchievement(achievement).stream()
                .map(ClientAchievement::getClient)
                .collect(Collectors.toList());
    }

}
