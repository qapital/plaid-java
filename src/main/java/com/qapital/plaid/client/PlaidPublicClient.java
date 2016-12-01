package com.qapital.plaid.client;

import com.qapital.plaid.client.http.HttpDelegate;
import com.qapital.plaid.client.response.InstitutionsResponse;

public interface PlaidPublicClient {
    
    InstitutionsResponse getAllInstitutions(Integer offset, Integer count);
    
    HttpDelegate getHttpDelegate();
}
