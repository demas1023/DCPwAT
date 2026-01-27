package com.demas.dcpa.data.mapper;

import com.demas.dcpa.data.dto.PublicationDTO;
import com.demas.dcpa.data.entity.Publication;

public class PublicationMapper {
    public static PublicationDTO getPublicationDTO(Publication publication) {
        return new PublicationDTO(
                publication.getTitle(),
                GameMapper.getGameDTO(publication.getGame()),
                ClientMapper.getClientDTO(publication.getAuthor()),
                publication.getContent(),
                publication.getPublicationRol(),
                publication.getPublicationDate(),
                publication.getRating());
    }

    public static Publication getPublication(PublicationDTO publicationDTO) {
        return new Publication(
               ClientMapper.getClient(publicationDTO.getAuthor()),
                GameMapper.getGame(publicationDTO.getGame()),
                publicationDTO.getTitle(),
                publicationDTO.getContent(),
                publicationDTO.getPublicationRol(),
                publicationDTO.getPublicationDate(),
                publicationDTO.getRating());
    }
}
