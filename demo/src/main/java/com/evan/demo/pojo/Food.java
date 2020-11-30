package com.evan.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "food")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name="cid")
    private Kind kind;

    String picture;
    String name;
    String cook;
    String abs;

    public void setId(int id) {
        this.id = id;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCook(String cook) {
        this.cook = cook;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public int getId() {
        return id;
    }

    public Kind getKind() {
        return kind;
    }

    public String getPicture() {
        return picture;
    }

    public String getName() {
        return name;
    }

    public String getCook() {
        return cook;
    }

    public String getAbs() {
        return abs;
    }
}


