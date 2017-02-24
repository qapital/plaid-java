package com.qapital.plaid.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriesResponse {

    private List<Category> categories;

    public CategoriesResponse(Category[] categories) {
        this.categories = Arrays.asList(categories);
    }

    public List<Category> getCategories() {
        return categories;
    }

}
