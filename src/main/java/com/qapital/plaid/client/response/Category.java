package com.qapital.plaid.client.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Category {

    private String id;
    private List<String> hierarchy;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(List<String> hierarchy) {
        this.hierarchy = hierarchy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", hierarchy=" + hierarchy +
                ", type='" + type + '\'' +
                '}';
    }
}