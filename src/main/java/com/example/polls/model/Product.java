package com.example.polls.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 140)
    private String name;

    @Size(max = 1000)
    private String description;

    private Long amount;

    @Size(max = 2000)
    private String image1;

    @Size(max = 2000)
    private String image2;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;


    public Product(@Size(max = 140) String name,
                   @Size(max = 1000) String description,
                   Long amount,
                   @Size(max = 2000) String image1,
                   @Size(max = 2000) String image2,
                   Partner partner,
                   Tag tag) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.image1 = image1;
        this.image2 = image2;
        this.partner = partner;
        this.tag = tag;
    }

    public Product(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(amount, product.amount) &&
                Objects.equals(image1, product.image1) &&
                Objects.equals(image2, product.image2) &&
                Objects.equals(partner, product.partner) &&
                Objects.equals(tag, product.tag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, amount, image1, image2, partner, tag);
    }
}
