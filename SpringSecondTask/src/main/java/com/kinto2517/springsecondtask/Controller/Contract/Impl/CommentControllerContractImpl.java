package com.kinto2517.springsecondtask.Controller.Contract.Impl;

import com.kinto2517.springsecondtask.Controller.Contract.CommentControllerContract;
import com.kinto2517.springsecondtask.Dto.CommentDTO;
import com.kinto2517.springsecondtask.Dto.CommentSaveRequest;
import com.kinto2517.springsecondtask.Entity.Comment;
import com.kinto2517.springsecondtask.Entity.Person;
import com.kinto2517.springsecondtask.Entity.Product;
import com.kinto2517.springsecondtask.Mapper.CommentMapper;
import com.kinto2517.springsecondtask.Service.CommentService;
import com.kinto2517.springsecondtask.Service.PersonService;
import com.kinto2517.springsecondtask.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.tokens.CommentToken;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentControllerContractImpl implements CommentControllerContract {

    private final CommentService commentService;

    private final ProductService productService;

    private final PersonService personService;

    @Override
    public CommentDTO saveComment(CommentSaveRequest commentSaveRequest) {
        Person person = personService.findById(commentSaveRequest.personId())
                .orElseThrow(() -> new RuntimeException("Person not found by id: " + commentSaveRequest.personId()));
        Product product = productService.findById(commentSaveRequest.productId())
                .orElseThrow(() -> new RuntimeException("Product not found by id: " + commentSaveRequest.productId()));

        Comment comment = new Comment(commentSaveRequest.comment(), person, product);
        Comment savedComment = commentService.save(comment);

        CommentDTO commentDTO = CommentMapper.INSTANCE.convertToDTO(savedComment);

        return commentDTO;
    }

    @Override
    public void deleteCommentById(Long id) {
        if (commentService.findById(id).isPresent()) {
            commentService.delete(id);
        } else {
            throw new RuntimeException("Comment not found by id: " + id);
        }
    }

    @Override
    public List<CommentDTO> findAllCommentsFromPerson(String username) {
        Person person = personService.findByUsername(username);
        List<Comment> commentList = commentService.findAllByPerson(person);
        return CommentMapper.INSTANCE.convertToDTOs(commentList);
    }
    @Override
    public List<CommentDTO> findAllCommentsFromProduct(Long id) {
        List<Comment> commentList = commentService.findAllByProductId(id);
        return CommentMapper.INSTANCE.convertToDTOs(commentList);
    }

    @Override
    public List<CommentDTO> findAllComments() {
        List<Comment> commentList = commentService.findAll();
        return CommentMapper.INSTANCE.convertToDTOs(commentList);
    }
}
