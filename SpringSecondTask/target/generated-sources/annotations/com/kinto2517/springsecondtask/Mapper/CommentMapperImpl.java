package com.kinto2517.springsecondtask.Mapper;

import com.kinto2517.springsecondtask.Dto.CommentDTO;
import com.kinto2517.springsecondtask.Dto.CommentSaveRequest;
import com.kinto2517.springsecondtask.Entity.Comment;
import com.kinto2517.springsecondtask.Entity.Person;
import com.kinto2517.springsecondtask.Entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-19T11:46:26+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment convertToComment(CommentSaveRequest commentSaveRequest) {
        if ( commentSaveRequest == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setPerson( commentSaveRequestToPerson( commentSaveRequest ) );
        comment.setProduct( commentSaveRequestToProduct( commentSaveRequest ) );
        comment.setComment( commentSaveRequest.comment() );

        return comment;
    }

    @Override
    public CommentDTO convertToDTO(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        Long id = null;
        String comment1 = null;
        Long personId = null;
        Long productId = null;

        id = comment.getId();
        comment1 = comment.getComment();
        personId = commentPersonId( comment );
        productId = commentProductId( comment );

        CommentDTO commentDTO = new CommentDTO( id, comment1, personId, productId );

        return commentDTO;
    }

    @Override
    public List<CommentDTO> convertToDTOs(List<Comment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<CommentDTO> list = new ArrayList<CommentDTO>( comments.size() );
        for ( Comment comment : comments ) {
            list.add( convertToDTO( comment ) );
        }

        return list;
    }

    protected Person commentSaveRequestToPerson(CommentSaveRequest commentSaveRequest) {
        if ( commentSaveRequest == null ) {
            return null;
        }

        Person person = new Person();

        person.setId( commentSaveRequest.personId() );

        return person;
    }

    protected Product commentSaveRequestToProduct(CommentSaveRequest commentSaveRequest) {
        if ( commentSaveRequest == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( commentSaveRequest.productId() );

        return product;
    }

    private Long commentPersonId(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        Person person = comment.getPerson();
        if ( person == null ) {
            return null;
        }
        Long id = person.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long commentProductId(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        Product product = comment.getProduct();
        if ( product == null ) {
            return null;
        }
        Long id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
