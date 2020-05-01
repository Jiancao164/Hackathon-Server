package com.example.wbdvsp20jannunziserverjava.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "recipe")
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    private String url;

    private String preTime;
    private String cookTime;
    private String servings;

    private Integer upvote = 0;
    private Integer downvote = 0;

    public Integer getUpvote() {
        return upvote;
    }

    public void setUpvote(Integer upvote) {
        this.upvote = upvote;
    }

    public Integer getDownvote() {
        return downvote;
    }

    public void setDownvote(Integer downvote) {
        this.downvote = downvote;
    }

    public String getPreTime() {
        return preTime;
    }

    public void setPreTime(String preTime) {
        this.preTime = preTime;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @OneToMany(mappedBy = "recipe", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Ingredient> ingredients;
    @OneToMany(mappedBy = "recipe", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Step> steps;
    @OneToMany(mappedBy = "recipe", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Nutrition> nutrition;

    public Set<Step> getSteps() {
        return steps;
    }

    public void setSteps(Set<Step> steps) {
        this.steps = steps;
    }

    public Set<Nutrition> getNutritions() {
        return nutrition;
    }

    public void setNutritions(Set<Nutrition> nutritions) {
        this.nutrition = nutritions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
