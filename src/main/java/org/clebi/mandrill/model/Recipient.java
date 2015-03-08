package org.clebi.mandrill.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Recipient {

    @JsonProperty("email")
    private String email;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    public Recipient(String email) {
        this.email = email;
    }

    public Recipient(String email, String name, String type) {
        this.email = email;
        this.name = name;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
