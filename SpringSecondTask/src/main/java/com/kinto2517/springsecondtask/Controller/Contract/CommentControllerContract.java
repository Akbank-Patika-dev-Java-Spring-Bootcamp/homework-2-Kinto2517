package com.kinto2517.springsecondtask.Controller.Contract;

import com.kinto2517.springsecondtask.Dto.CommentDTO;
import com.kinto2517.springsecondtask.Dto.CommentSaveRequest;

import java.util.List;

public interface CommentControllerContract {

    CommentDTO saveComment(CommentSaveRequest commentSaveRequest);

    void deleteCommentById(Long id);

    List<CommentDTO> findAllCommentsFromPerson(String username);

    List<CommentDTO> findAllCommentsFromProduct(Long id);

    List<CommentDTO> findAllComments();


}
