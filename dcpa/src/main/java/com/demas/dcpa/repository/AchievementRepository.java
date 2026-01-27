package com.demas.dcpa.repository;


import com.demas.dcpa.data.entity.Achievement;
import com.demas.dcpa.data.entity.Game;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AchievementRepository {

    boolean createAchievement(Achievement achievement);
    boolean updateAchievement(Achievement achievement);
    boolean deleteAchievement(Achievement achievement);

    Optional<Achievement> findAchievementById(int id);

    List<Achievement> findAllAchievements();
    List<Achievement> findAllAchievementsByGame(Game game);
}
