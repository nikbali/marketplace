package com.example.polls.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private long id;

    private BigDecimal amount;


    // написать кастомный сериализатор в json  @JsonSerialize(using = CustomDateSerializer.class)
    private Instant date;

    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusOperation status;

    @Column(name = "count")
    private Integer count;


    @ManyToOne(optional = false )
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(optional = false )
    @JoinColumn(name = "user_id",  referencedColumnName = "id")
    private User user;


    public Operation(){}

    public Operation(BigDecimal amount,
                     Instant date,
                     String description,
                     StatusOperation status,
                     Product product,
                     User user,
                     Integer count) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.status = status;
        this.product = product;
        this.user = user;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusOperation getStatus() {
        return status;
    }

    public void setStatus(StatusOperation status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", product=" + product +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(amount, operation.amount) &&
                Objects.equals(date, operation.date) &&
                Objects.equals(description, operation.description) &&
                status == operation.status &&
                Objects.equals(product, operation.product) &&
                Objects.equals(user, operation.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount, date, description, status, product, user);
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
