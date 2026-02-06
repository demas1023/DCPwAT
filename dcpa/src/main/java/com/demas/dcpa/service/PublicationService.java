package com.demas.dcpa.service;

import com.demas.dcpa.data.dto.ClientDTO;
import com.demas.dcpa.data.dto.PublicationDTO;
import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.data.entity.Game;
import com.demas.dcpa.data.entity.Publication;
import com.demas.dcpa.data.mapper.ClientMapper;
import com.demas.dcpa.data.mapper.PublicationMapper;
import com.demas.dcpa.data.rol.PublicationRol;
import com.demas.dcpa.repository.PublicationRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublicationService {
    private final PublicationRepository publicationRepository;

    public PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public boolean addPublication(PublicationDTO publicationDTO) {
        Publication publication = PublicationMapper.getPublication(publicationDTO);
        return publicationRepository.addPublication(publication);
    }

    public boolean deletePublication(PublicationDTO publicationDTO) {
        Publication publication = PublicationMapper.getPublication(publicationDTO);
        return publicationRepository.deletePublication(publication);
    }

    public boolean updatePublication(PublicationDTO publicationDTO) {
        Publication publication = PublicationMapper.getPublication(publicationDTO);
        return publicationRepository.updatePublication(publication);
    }

    public PublicationDTO findPublicationByName(String name) {
        Optional<Publication> publicationOpt = publicationRepository.findPublicationByName(name);
        if (publicationOpt.isPresent()) {
            return PublicationMapper.getPublicationDTO(publicationOpt.get());
        } else {
            throw new RuntimeException("Publication not found");
        }
    }

    public PublicationDTO findPublicationById(int id) {
        Optional<Publication> publicationOpt = publicationRepository.findPublicationById(id);
        if (publicationOpt.isPresent()) {
            return PublicationMapper.getPublicationDTO(publicationOpt.get());
        } else {
            throw new NoSuchElementException("Publication not found with id: " + id);
        }
    }

    public List<PublicationDTO> findAllPublications() {
        return publicationRepository.findAllPublications().stream()
                .map(PublicationMapper::getPublicationDTO)
                .collect(Collectors.toList());
    }

    public List<PublicationDTO> findAllPublicationsByName(String name) {
        return publicationRepository.findAllPublicationsByName(name).stream()
                .map(PublicationMapper::getPublicationDTO)
                .collect(Collectors.toList());
    }

    public List<PublicationDTO> findAllPublicationsByGame(Game game) {
        return publicationRepository.findAllPublicationsByGame(game).stream()
                .map(PublicationMapper::getPublicationDTO)
                .collect(Collectors.toList());
    }

    public List<PublicationDTO> findAllPublicationsByAuthor(ClientDTO author) {
        Client authorEntity = ClientMapper.getClient(author);
        return publicationRepository.findAllPublicationsByAuthor(authorEntity).stream()
                .map(PublicationMapper::getPublicationDTO)
                .collect(Collectors.toList());
    }

    public List<PublicationDTO> findAllPublicationsBetweenDates(Date startDate, Date endDate) {
        return publicationRepository.findAllPublicationsBetweenDates(startDate, endDate).stream()
                .map(PublicationMapper::getPublicationDTO)
                .filter(p -> p.getPublicationRol().equals(PublicationRol.POST))
                .collect(Collectors.toList());
    }

    public List<PublicationDTO> findAllDevlogsBetweenDates(Date startDate, Date endDate) {
        return publicationRepository.findAllPublicationsBetweenDates(startDate, endDate).stream()
                .map(PublicationMapper::getPublicationDTO)
                .filter(d -> d.getPublicationRol().equals(PublicationRol.DEVLOG))
                .collect(Collectors.toList());
    }

}
