package com.demas.dcpa.service;

import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.data.entity.Game;
import com.demas.dcpa.data.entity.Publication;
import com.demas.dcpa.repository.PublicationRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PublicationService {
    private final PublicationRepository publicationRepository;

    public PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public boolean addPublication(Publication publication) {
        return publicationRepository.addPublication(publication);
    }

    public boolean deletePublication(Publication publication) {
        return publicationRepository.deletePublication(publication);
    }

    public boolean updatePublication(Publication publication) {
        return publicationRepository.updatePublication(publication);
    }

    public Publication findPublicationByName(String name) {
        return publicationRepository.findPublicationByName(name)
                .orElseThrow(() -> new NoSuchElementException("Publication not found with name: " + name));
    }

    public Publication findPublicationById(int id) {
        return publicationRepository.findPublicationById(id)
                .orElseThrow(() -> new NoSuchElementException("Publication not found with id: " + id));
    }

    public List<Publication> findAllPublications() {
        return publicationRepository.findAllPublications();
    }

    public List<Publication> findAllPublicationsByName(String name) {
        return publicationRepository.findAllPublicationsByName(name);
    }

    public List<Publication> findAllPublicationsByGame(Game game) {
        return publicationRepository.findAllPublicationsByGame(game);
    }

    public List<Publication> findAllPublicationsByAuthor(Client author) {
        return publicationRepository.findAllPublicationsByAuthor(author);
    }

    public List<Publication> findAllPublicationsBetweenDates(Date startDate, Date endDate) {
        return publicationRepository.findAllPublicationsBetweenDates(startDate, endDate);
    }

}
