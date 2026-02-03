package com.demas.dcpa.service;

import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.data.entity.Comment;
import com.demas.dcpa.data.entity.Publication;
import com.demas.dcpa.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public boolean createComment(Comment comment) {
        return commentRepository.createComment(comment);
    }

    public boolean updateComment(Comment comment) {
        return commentRepository.updateComment(comment);
    }

    public boolean deleteComment(Comment comment) {
        return commentRepository.deleteComment(comment);
    }

    public Comment findCommentById(int id) {
        return commentRepository.findCommentById(id)
                .orElseThrow(() -> new NoSuchElementException("Comment not found with id: " + id));
    }

    public List<Comment> findAllCommentsByPublication(Publication publication) {
        return commentRepository.findAllCommentsByPublication(publication);
    }

    public List<Comment> findAllCommentsByAuthor(Client author) {
        return commentRepository.findAllCommentsByAuthor(author);
    }

}
