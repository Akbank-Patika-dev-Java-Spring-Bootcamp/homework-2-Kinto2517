package com.kinto2517.springsecondtask.Controller;

import com.kinto2517.springsecondtask.Controller.Contract.CommentControllerContract;
import com.kinto2517.springsecondtask.Dto.CommentDTO;
import com.kinto2517.springsecondtask.Dto.CommentSaveRequest;
import com.kinto2517.springsecondtask.Entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentControllerContract commentControllerContract;

    @GetMapping("/allbyperson")
    public ResponseEntity<List<CommentDTO>> getAllCommentFromPerson (@RequestParam("username") String username) {
        List<CommentDTO> commentDTOList = commentControllerContract.findAllCommentsFromPerson(username);
        if (commentDTOList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(commentDTOList);
        }
    }

    @GetMapping("/allbyproduct")
    public ResponseEntity<List<CommentDTO>> getAllCommentFromProduct (@RequestParam("id") Long id) {
        List<CommentDTO> commentDTOList = commentControllerContract.findAllCommentsFromProduct(id);
        if (commentDTOList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(commentDTOList);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<CommentDTO>> getAllComment () {
        List<CommentDTO> commentDTOList = commentControllerContract.findAllComments();
        if (commentDTOList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(commentDTOList);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<CommentDTO> saveComment (@RequestBody CommentSaveRequest commentSaveRequest) {
        CommentDTO commentDTO = commentControllerContract.saveComment(commentSaveRequest);
        return ResponseEntity.ok(commentDTO);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<CommentDTO>> deleteComment (@RequestParam("id") Long id) {
        commentControllerContract.deleteCommentById(id);
        return ResponseEntity.ok().build();
    }

}
