package com.kinto2517.springsecondtask.Service;

import com.kinto2517.springsecondtask.Base.BaseEntityService;
import com.kinto2517.springsecondtask.Dao.CommentRepository;
import com.kinto2517.springsecondtask.Dao.PersonRepository;
import com.kinto2517.springsecondtask.Dao.ProductRepository;
import com.kinto2517.springsecondtask.Entity.Comment;
import com.kinto2517.springsecondtask.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService extends BaseEntityService<Comment, CommentRepository>{
    public CommentService(CommentRepository repository, CommentRepository commentRepository, ProductRepository productRepository, PersonRepository personRepository) {
        super(repository);
    }

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> findAllByPerson(Person person) {
        return commentRepository.findAllByPerson(person);
    }

    public List<Comment> findAllByProductId(Long id) {
        return commentRepository.findAllByProductId(id);
    }

}
