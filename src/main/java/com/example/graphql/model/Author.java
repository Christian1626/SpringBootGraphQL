package com.example.graphql.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author LEROY Christian - Orange / IMT / OLPS / SOFT
 */
@Entity
@NoArgsConstructor
public @Data class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    public Author(Long id) {
        this.id = id;
    }
}
