package org.clebi.mandrill.model;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class MessageStatus {

    private String _id;

    private String status;

    private String email;

    private String reject_reason;

    @JsonCreator
    public MessageStatus(@JsonProperty("_id") String _id,
                               @JsonProperty("status") String status,
                               @JsonProperty("email") String email,
                               @JsonProperty("reject_reason") String reject_reason) {
        this._id = _id;
        this.status = status;
        this.email = email;
        this.reject_reason = reject_reason;
    }

    @Override
    public String toString() {
        return "SendMessageResponse{" +
                "_id='" + _id + '\'' +
                ", status='" + status + '\'' +
                ", email='" + email + '\'' +
                ", reject_reason='" + reject_reason + '\'' +
                '}';
    }

}
