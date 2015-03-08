package org.clebi.mandrill.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class MergeVar {

    @JsonProperty("name")
    private String name;

    @JsonProperty("content")
    private String content;

    public MergeVar(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
