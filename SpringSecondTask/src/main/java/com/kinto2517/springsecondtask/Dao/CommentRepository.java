package com.kinto2517.springsecondtask.Dao;

import com.kinto2517.springsecondtask.Entity.Comment;
import com.kinto2517.springsecondtask.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.person = :person")
    List<Comment> findAllByPerson(Person person);

    @Query("SELECT c FROM Comment c WHERE c.product.id = :id")
    List<Comment> findAllByProductId(Long id);
}