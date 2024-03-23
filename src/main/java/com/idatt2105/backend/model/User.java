package com.idatt2105.backend.model;

import io.swagger.v3.oas.annotations.Hidden;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.JoinColumn;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Hidden
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotEmpty
    @Column(name = "password", nullable = false)
    private String password;

    @Hidden
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_quiz",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "quiz_id", referencedColumnName = "id"))
    private Set<Quiz> quizzes = new HashSet<>();
}