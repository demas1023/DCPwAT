package com.demas.dcpa.data.mapper;

import com.demas.dcpa.data.dto.AchievementDTO;
import com.demas.dcpa.data.entity.Achievement;

public class AchievementMapper {
    public static Achievement getAchivement(AchievementDTO achievementDTO) {
        return new Achievement(achievementDTO.getTitle(), achievementDTO.getDescription(), achievementDTO.getIcon(), achievementDTO.getCondition(), achievementDTO.isCompleted());
    }

    public static AchievementDTO getAchivementDTO(Achievement achievement) {
        return new AchievementDTO(achievement.getTitle(), achievement.getDescription(),  achievement.getIcon(), achievement.getCondition(), achievement.isCompleted());
    }
}
