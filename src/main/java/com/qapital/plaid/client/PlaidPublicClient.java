package com.qapital.plaid.client;

import com.qapital.plaid.client.http.HttpDelegate;
import com.qapital.plaid.client.response.CategoriesResponse;
import com.qapital.plaid.client.response.InstitutionsResponse;

public interface PlaidPublicClient {
    
    InstitutionsResponse getAllInstitutions(Integer offset, Integer count);

    CategoriesResponse getAllCategories();

    HttpDelegate getHttpDelegate();
}
