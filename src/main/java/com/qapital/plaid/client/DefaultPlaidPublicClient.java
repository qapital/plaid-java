package com.qapital.plaid.client;

import com.qapital.plaid.client.exception.PlaidClientsideException;
import com.qapital.plaid.client.http.HttpDelegate;
import com.qapital.plaid.client.http.HttpResponseWrapper;
import com.qapital.plaid.client.http.PlaidHttpRequest;
import com.qapital.plaid.client.response.CategoriesResponse;
import com.qapital.plaid.client.response.Category;
import com.qapital.plaid.client.response.InstitutionsResponse;
import org.apache.commons.lang.StringUtils;

public class DefaultPlaidPublicClient implements PlaidPublicClient {

    private HttpDelegate httpDelegate;

    private String clientId;
    private String secret;

    @Override
    public InstitutionsResponse getAllInstitutions(Integer offset, Integer count) {
        PlaidHttpRequest request = new PlaidHttpRequest("/institutions/all");
        if(StringUtils.isEmpty(clientId) || StringUtils.isEmpty(secret)) {
            throw new PlaidClientsideException("ClientId and Secret is required");
        }
        request.addParameter("client_id", clientId);
        request.addParameter("secret", secret);

        if(count != null) {
            request.addParameter("count", count.toString());
        }

        if(offset != null) {
            request.addParameter("offset", offset.toString());
        }
        HttpResponseWrapper<InstitutionsResponse> response = httpDelegate.doPost(request, InstitutionsResponse.class);
        return response.getResponseBody();
    }

    @Override
    public CategoriesResponse getAllCategories() {
        PlaidHttpRequest request = new PlaidHttpRequest("/categories");
        HttpResponseWrapper<Category[]> response = httpDelegate.doGet(request, Category[].class);
        return new CategoriesResponse(response.getResponseBody());
    }

    @Override
    public HttpDelegate getHttpDelegate() {
    	return httpDelegate;
    }

    public static class Builder {

        private String clientId;
        private String secret;
        private HttpDelegate httpDelegate;

        public Builder withClientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder withSecret(String secret) {
            this.secret = secret;
            return this;
        }

        public Builder withHttpDelegate(HttpDelegate httpDelegate) {
            this.httpDelegate = httpDelegate;
            return this;
        }

        public DefaultPlaidPublicClient build() {

            DefaultPlaidPublicClient client = new DefaultPlaidPublicClient();
            client.clientId = this.clientId;
            client.secret = this.secret;
            client.httpDelegate = this.httpDelegate;

            return client;
        }
    }

}
