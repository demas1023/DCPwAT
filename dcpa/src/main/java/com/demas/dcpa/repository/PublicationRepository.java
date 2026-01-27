package com.demas.dcpa.repository;

import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.data.entity.Game;
import com.demas.dcpa.data.entity.Publication;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PublicationRepository {

    boolean addPublication(Publication publication);
    boolean deletePublication(Publication publication);
    boolean updatePublication(Publication publication);

    Optional<Publication> findPublicationByName(String name);
    Optional<Publication> findPublicationById(int id);

    List<Publication> findAllPublications();
    List<Publication> findAllPublicationsByName(String name);
    List<Publication> findAllPublicationsByGame(Game game);
    List<Publication> findAllPublicationsByAuthor(Client author);
    List<Publication> findAllPublicationsBetweenDates(Date startDate, Date endDate);

}
