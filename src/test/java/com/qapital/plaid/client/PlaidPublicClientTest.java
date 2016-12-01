package com.qapital.plaid.client;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import com.qapital.plaid.client.exception.PlaidClientsideException;
import com.qapital.plaid.client.http.HttpDelegate;
import com.qapital.plaid.client.response.Institution;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;

import com.qapital.plaid.client.http.ApacheHttpClientHttpDelegate;
import com.qapital.plaid.client.response.InstitutionsResponse;

public class PlaidPublicClientTest {
    
    private CloseableHttpClient httpClient;
    private PlaidPublicClient plaidPublicClientWithoutCredentials;
    private PlaidPublicClient plaidPublicClientWithCredentials;

    @Before
    public  void setup() {
        httpClient = HttpClients.custom().disableContentCompression().build();
        HttpDelegate httpDelegate = new ApacheHttpClientHttpDelegate("https://tartan.plaid.com", httpClient);
        plaidPublicClientWithoutCredentials = new DefaultPlaidPublicClient.Builder()
                .withHttpDelegate(httpDelegate)
                .build();

        plaidPublicClientWithCredentials = new DefaultPlaidPublicClient.Builder()
                .withHttpDelegate(httpDelegate)
                .withClientId("test_id")
                .withSecret("test_secret")
                .build();
    }

    @Test
    public void testGetAllInstitutions() {
        InstitutionsResponse instResponse = plaidPublicClientWithCredentials.getAllInstitutions(0, 10);
        assertNotNull(instResponse);
        Institution[] institutions = instResponse.getResults();
        Map<String, Institution> map = new HashMap<>();
        for (Institution institution : institutions) {
            map.put(institution.getName(), institution);
        }

        assertNotNull(map.get("Bank of America"));
    }

    @Test(expected = PlaidClientsideException.class)
    public void testGetAllInstitutionsRequireCredentials() throws Exception {
        plaidPublicClientWithoutCredentials.getAllInstitutions(0, 10);
    }
}
