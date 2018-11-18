package com.example.polls.dto;

import java.util.Objects;

public class ItemOrderDTO {
    private Long id;
    private Integer count;

    public ItemOrderDTO(){}
    public ItemOrderDTO(Long id, Integer count) {
        this.id = id;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemOrderDTO that = (ItemOrderDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, count);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
