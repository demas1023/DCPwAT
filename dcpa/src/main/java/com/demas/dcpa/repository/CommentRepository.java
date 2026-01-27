package com.demas.dcpa.repository;

import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.data.entity.Comment;
import com.demas.dcpa.data.entity.Publication;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository {

    boolean createComment(Comment comment);
    boolean updateComment(Comment comment);
    boolean deleteComment(Comment comment);

    Optional<Comment> findCommentById(int id);

    List<Comment> findAllCommentsByPublication(Publication publication);
    List<Comment> findAllCommentsByAuthor(Client author);
}
