package com.kinto2517.springsecondtask.Dao;

import com.kinto2517.springsecondtask.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.username = :username AND p.phone = :phone")
    Person findByUsernameAndPhone(String username, String phone);

    @Query("SELECT p FROM Person p WHERE p.username = :username")
    Person findByUsername(String username);


}