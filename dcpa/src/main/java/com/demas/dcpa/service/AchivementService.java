package com.demas.dcpa.service;

import com.demas.dcpa.data.dto.AchievementDTO;
import com.demas.dcpa.data.dto.ClientDTO;
import com.demas.dcpa.data.dto.GameDTO;
import com.demas.dcpa.data.entity.*;
import com.demas.dcpa.data.mapper.AchievementMapper;
import com.demas.dcpa.data.mapper.ClientMapper;
import com.demas.dcpa.data.mapper.GameMapper;
import com.demas.dcpa.repository.AchievementRepository;
import com.demas.dcpa.repository.ClientAchievementRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AchivementService {

    private final AchievementRepository achievementRepository;
    private final ClientAchievementRepository clientAchievementRepository;

    public AchivementService(AchievementRepository achievementRepository, ClientAchievementRepository clientAchievementRepository) {
        this.achievementRepository = achievementRepository;
        this.clientAchievementRepository = clientAchievementRepository;
    }

    public List<AchievementDTO> getAchievementsByGame(GameDTO gameDTO) {
        Game game = GameMapper.getGame(gameDTO);
        return achievementRepository.findAllAchievementsByGame(game).stream()
                .map(AchievementMapper::getAchivementDTO)
                .collect(Collectors.toList());
    }

    public List<AchievementDTO> getAchievementsByClient(ClientDTO clientDTO) {
        Client client = ClientMapper.getClient(clientDTO);
        return clientAchievementRepository.findAllClientAchievementsByClient(client).stream()
                .map(ClientAchievement::getAchievement)
                .map(AchievementMapper::getAchivementDTO)
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<AchievementDTO> findAllAchievements() {
        return achievementRepository.findAllAchievements().stream()
                .map(AchievementMapper::getAchivementDTO)
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasRole('DEVELOPER')")
    public boolean addAchivement(AchievementDTO achievementDTO, GameDTO gameDTO, String element) {
        Game game = GameMapper.getGame(gameDTO);
        Achievement achievement = AchievementMapper.getAchivement(achievementDTO);
        achievement.setGame(game);
        achievement.setElement(element);
        return achievementRepository.createAchievement(achievement);
    }

    public boolean updateAchivement(AchievementDTO achievementDTO, GameDTO gameDTO) {
        Game game = GameMapper.getGame(gameDTO);
        Achievement achievement = AchievementMapper.getAchivement(achievementDTO);
        achievement.setGame(game);
        return achievementRepository.updateAchievement(achievement);
    }

    @PreAuthorize("hasAnyRole('DEVELOPER','ADMIN')")
    public boolean removeAchivement(AchievementDTO achievementDTO, GameDTO gameDTO) {
        Game game = GameMapper.getGame(gameDTO);
        Achievement achievement = AchievementMapper.getAchivement(achievementDTO);
        achievement.setGame(game);
        return achievementRepository.deleteAchievement(achievement);
    }
}
