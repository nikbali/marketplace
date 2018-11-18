package com.example.polls.dto;

import java.math.BigDecimal;

public class ProductCreateRequestDTO {

    private String name;
    private String description;
    private Integer amount;
    private Integer count;
    private String image1;
    private String partner;
    private String tag;


    public ProductCreateRequestDTO(String name, String description, Integer amount, Integer count, String image1, String partner, String tag) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.count = count;
        this.image1 = image1;
        this.partner = partner;
        this.tag = tag;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
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
}
