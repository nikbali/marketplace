package com.example.polls.dto;

import java.util.List;

public class ProductByOkvdRequestDTO {
    private String mainCategory;
    private List<String> okvds;

    public ProductByOkvdRequestDTO(){}
    public ProductByOkvdRequestDTO(String mainCategory, List<String> okvds) {
        this.mainCategory = mainCategory;
        this.okvds = okvds;
    }

    public String getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    public List<String> getOkvds() {
        return okvds;
    }

    public void setOkvds(List<String> okvds) {
        this.okvds = okvds;
    }
}
