package com.example.polls.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 500)
    private String title;

    private String okved;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tag")
    private List<Product> productList;

    public Tag(@Size(max = 500) String title, String okved) {
        this.title = title;
        this.okved = okved;
    }

    public Tag(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOkved() {
        return okved;
    }

    public void setOkved(String okved) {
        this.okved = okved;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
