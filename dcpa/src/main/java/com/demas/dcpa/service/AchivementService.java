package com.demas.dcpa.service;

import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.data.entity.Game;
import com.demas.dcpa.data.entity.Publication;
import com.demas.dcpa.repository.GameRepository;
import com.demas.dcpa.repository.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchivementService {

    private final PublicationRepository publicationRepository;

    public AchivementService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public List<Publication> getAllPublications() {
        return publicationRepository.findAllPublications();
    }

    public List<Publication> getAllPublicationsByGame(Game game) {
        return publicationRepository.findAllPublicationsByGame(game);
    }


    public List<Publication> getAllPublicationsByAuthor(Client author){
        return publicationRepository.findAllPublicationsByAuthor(author);
    }

    public boolean addPublication(Publication publication) {
        return publicationRepository.addPublication(publication);
    }

    public boolean removePublication(Publication publication) {
        return publicationRepository.deletePublication(publication);
    }
}
