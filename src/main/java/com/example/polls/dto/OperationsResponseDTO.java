package com.example.polls.dto;

import java.math.BigDecimal;

public class OperationsResponseDTO {

    private Long id;
    private String description;
    private String product;
    private String date;
    private BigDecimal amount;
    private String status;
    private String user;
    private String image;
    private Integer count;

    public OperationsResponseDTO(){}
    public OperationsResponseDTO(Long id, String description, String product, String date, BigDecimal amount, String status, String user,String image,Integer count) {
        this.id = id;
        this.description = description;
        this.product = product;
        this.date = date;
        this.amount = amount;
        this.status = status;
        this.user = user;
        this.count = count;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
