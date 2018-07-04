package com.example.graphql.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author LEROY Christian - Orange / IMT / OLPS / SOFT
 */
@Entity
public @Data class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;

    private String isbn;

    private int pageCount;

    @ManyToOne
    @JoinColumn(name = "author_id",
            nullable = false, updatable = false)
    private Author author;
}
