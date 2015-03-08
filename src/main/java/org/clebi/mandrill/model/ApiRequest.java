package org.clebi.mandrill.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApiRequest {

    /**
     * api key
     */
    @JsonProperty("key")
    private String key;

    public ApiRequest() {
    }

    public ApiRequest(String key) {
        this.key = key;
    }

    /**
     * get api key
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * set api key
     * @param key the key
     */
    public void setKey(String key) {
        this.key = key;
    }
}
