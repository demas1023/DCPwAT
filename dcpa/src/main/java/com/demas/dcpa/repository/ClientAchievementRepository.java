package com.demas.dcpa.repository;

import com.demas.dcpa.data.entity.Achievement;
import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.data.entity.ClientAchievement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientAchievementRepository {

    List<ClientAchievement> findAllClientAchievementsByClient(Client client); //for the client to see their achievements
    List<ClientAchievement> findAllClientAchievementsByAchievement(Achievement achievement); //for the developer to see the amount of clients that have completed the achievement/s

    boolean completeAchievement(ClientAchievement achievement);

}
