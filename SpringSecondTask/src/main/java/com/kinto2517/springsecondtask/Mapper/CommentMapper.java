package com.kinto2517.springsecondtask.Mapper;

import com.kinto2517.springsecondtask.Dto.CommentDTO;
import com.kinto2517.springsecondtask.Dto.CommentSaveRequest;
import com.kinto2517.springsecondtask.Entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(source = "commentSaveRequest.comment", target = "comment")
    @Mapping(source = "commentSaveRequest.personId", target = "person.id")
    @Mapping(source = "commentSaveRequest.productId", target = "product.id")
    Comment convertToComment(CommentSaveRequest commentSaveRequest);

    @Mapping(source = "comment.id", target = "id")
    @Mapping(source = "comment.comment", target = "comment")
    @Mapping(source = "comment.person.id", target = "personId")
    @Mapping(source = "comment.product.id", target = "productId")
    CommentDTO convertToDTO(Comment comment);

    List<CommentDTO> convertToDTOs(List<Comment> comments);

}
