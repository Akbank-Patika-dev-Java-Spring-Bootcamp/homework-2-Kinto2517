package com.kinto2517.springsecondtask.Entity;

import com.kinto2517.springsecondtask.Base.BaseEntity;
import com.kinto2517.springsecondtask.Enums.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "person")
@Getter
@Setter
@ToString
public class Person extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String mail;

    @Column(unique = true, nullable = false)
    private String phone;

    @Column(nullable = false)
    private UserType userType;

    public Person() {
    }
    public Person(String username, String mail, String phone, UserType userType) {
        this.username = username;
        this.mail = mail;
        this.phone = phone;
        this.userType = userType;
    }
}
