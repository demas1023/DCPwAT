package com.demas.dcpa.service;

import com.demas.dcpa.data.dto.ClientDTO;
import com.demas.dcpa.data.dto.CommentDTO;
import com.demas.dcpa.data.dto.PublicationDTO;
import com.demas.dcpa.data.mapper.ClientMapper;
import com.demas.dcpa.data.mapper.CommentMapper;
import com.demas.dcpa.data.mapper.PublicationMapper;
import com.demas.dcpa.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public boolean createComment(CommentDTO comment) {
        return commentRepository.createComment(CommentMapper.getComment(comment));
    }

    public boolean updateComment(CommentDTO comment) {
        return commentRepository.updateComment(CommentMapper.getComment(comment));
    }

    public boolean deleteComment(CommentDTO comment) {
        return commentRepository.deleteComment(CommentMapper.getComment(comment));
    }

    public CommentDTO findCommentById(int id) {
        return commentRepository.findCommentById(id).map(CommentMapper::getCommentDTO)
                .orElseThrow(() -> new NoSuchElementException("Comment not found with id: " + id));
    }

    public List<CommentDTO> findAllCommentsByPublication(PublicationDTO publication) {
        return commentRepository.findAllCommentsByPublication(PublicationMapper.getPublication(publication))
                .stream().map(CommentMapper::getCommentDTO)
                .collect(Collectors.toList());
    }

    public List<CommentDTO> findAllCommentsByAuthor(ClientDTO author) {
        return commentRepository.findAllCommentsByAuthor(ClientMapper.getClient(author))
                .stream().map(CommentMapper::getCommentDTO)
                .collect(Collectors.toList());
    }

}
