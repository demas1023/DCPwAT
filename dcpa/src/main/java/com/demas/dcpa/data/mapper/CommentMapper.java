package com.demas.dcpa.data.mapper;


import com.demas.dcpa.data.dto.CommentDTO;
import com.demas.dcpa.data.dto.PublicationDTO;
import com.demas.dcpa.data.entity.Comment;
import com.demas.dcpa.data.entity.Publication;

public class CommentMapper {
    public static CommentDTO getCommentDTO(Comment comment) {
        return new CommentDTO(
                PublicationMapper.getPublicationDTO(comment.getPublication()),
                ClientMapper.getClientDTO(comment.getCommenter()),
                comment.getComment(),
                comment.getCommentDate(),
                comment.getRating());
    }

    public static Comment getComment(CommentDTO commentDTO) {
        return new Comment(
                ClientMapper.getClient(commentDTO.getClient()),
                PublicationMapper.getPublication(commentDTO.getPublication()),
                commentDTO.getComment(),
                commentDTO.getCommentDate(),
                commentDTO.getRating());
    }

}
