package com.qapital.plaid.client.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.qapital.plaid.client.response.joda.AnnotationDateTimeDeserializer;
import org.joda.time.DateTime;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TransactionsResponse extends AccountsResponse {

    private List<Transaction> transactions;
    private DateTime LastUpdated;
    
    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @JsonProperty("last_updated")
    @JsonDeserialize(using = AnnotationDateTimeDeserializer.class)
    public DateTime getLastUpdated() {
        return LastUpdated;
    }

    public void setLastUpdated(DateTime lastUpdated) {
        LastUpdated = lastUpdated;
    }
}
