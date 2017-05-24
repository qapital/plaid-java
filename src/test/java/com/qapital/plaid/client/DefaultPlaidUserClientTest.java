package com.qapital.plaid.client;

import org.junit.Before;
import org.junit.Test;

import static com.qapital.plaid.client.DefaultPlaidUserClient.TEST_USER_ACCESS_TOKEN_PREFIX;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DefaultPlaidUserClientTest {

    private DefaultPlaidUserClient defaultPlaidUserClient;

    @Before
    public void setup() {
        defaultPlaidUserClient = new DefaultPlaidUserClient.Builder().build();
    }

    @Test
    public void checkIfProductionAccount() {
        defaultPlaidUserClient.setAccessToken("3e2e23e3dd332d32d333");
        assertTrue(defaultPlaidUserClient.isProductionAccount());

        defaultPlaidUserClient.setAccessToken("3e2e23e3dd332d32d333" + TEST_USER_ACCESS_TOKEN_PREFIX);
        assertTrue(defaultPlaidUserClient.isProductionAccount());
    }

    @Test
    public void checkIfAccountTypeWhenEmptyAccessToken() {
        defaultPlaidUserClient.setAccessToken("");
        assertFalse(defaultPlaidUserClient.isProductionAccount());

        defaultPlaidUserClient.setAccessToken(null);
        assertFalse(defaultPlaidUserClient.isProductionAccount());
    }

    @Test
    public void checkIfTestAccount() {
        defaultPlaidUserClient.setAccessToken(TEST_USER_ACCESS_TOKEN_PREFIX + "1234");
        assertFalse(defaultPlaidUserClient.isProductionAccount());
    }
}
