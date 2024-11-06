package com.prijilevschi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "isBorrowed", nullable = false)
    private Boolean isBorrowed = Boolean.FALSE;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        isBorrowed = borrowed;
    }
}
