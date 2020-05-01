package com.example.wbdvsp20jannunziserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "nutrition")
public class Nutrition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 5000)
    @Column(length = 5000)
    private String nutritionDetail;

    @ManyToOne
    @JsonIgnore
    private Recipe recipe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNutritionDetail() {
        return nutritionDetail;
    }

    public void setNutritionDetail(String nutritionDetail) {
        this.nutritionDetail = nutritionDetail;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
