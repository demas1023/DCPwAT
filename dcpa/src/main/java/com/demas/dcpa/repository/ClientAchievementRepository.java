package com.demas.dcpa.repository;

import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.data.entity.ClientAchievement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientAchievementRepository {

    List<ClientAchievement> findAllClientAchievementsByClient(Client client);

    boolean completeAchievement(ClientAchievement achievement);

}
