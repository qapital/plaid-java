package com.plaid.client;

import com.plaid.client.http.HttpDelegate;
import com.plaid.client.response.InstitutionsResponse;

public interface PlaidPublicClient {
    
    InstitutionsResponse getAllInstitutions(Integer offset, Integer count);
    
    HttpDelegate getHttpDelegate();
}
