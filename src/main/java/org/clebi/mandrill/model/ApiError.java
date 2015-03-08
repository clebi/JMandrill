package org.clebi.mandrill.model;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class ApiError {

    private String status;

    private int code;

    private String name;

    private String message;

    @JsonCreator
    public ApiError(@JsonProperty("status") String status,
                    @JsonProperty("code") int code,
                    @JsonProperty("name") String name,
                    @JsonProperty("message") String message) {
        this.status = status;
        this.code = code;
        this.name = name;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "status='" + status + '\'' +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
