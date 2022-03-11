package com.LibraryManagement.Entity;

import javax.persistence.*;

@Entity
@Table(name="Books")
public class BooksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id",nullable = false)
    private Long id2;
    private String name;
    private String writer;
    private String Summary;
    private String category;

    public BooksEntity(Long id2, String name, String writer, String summary, String category) {
        this.id2 = id2;
        this.name = name;
        this.writer = writer;
        this.Summary = summary;
        this.category = category;
    }

    public BooksEntity() {
    }

    public Long getId() {
        return id2;
    }

    public void setId(Long id2) {
        this.id2 = id2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        this.Summary = summary;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
