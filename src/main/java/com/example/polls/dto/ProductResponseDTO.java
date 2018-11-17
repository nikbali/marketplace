package com.example.polls.dto;

import com.example.polls.model.Partner;
import com.example.polls.model.Product;
import com.example.polls.model.Tag;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Long amount;
    private String image1;
    private String image2;
    private String partner;
    private String tag;

    public ProductResponseDTO(){}
    public ProductResponseDTO(final Long id,
                              final String name,
                              final String description,
                              final Long amount,
                              final String image1,
                              final String image2,
                              final String partner,
                              final String tag) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.image1 = image1;
        this.image2 = image2;
        this.partner = partner;
        this.tag = tag;
    }

    public ProductResponseDTO(final Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.amount = product.getAmount();
        this.image1 = product.getImage1();
        this.image2 = product.getImage2();
        if(product.getPartner() != null) this.partner = product.getPartner().getName();
        if(product.getTag() != null) this.tag = product.getTag().getTitle();
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

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
