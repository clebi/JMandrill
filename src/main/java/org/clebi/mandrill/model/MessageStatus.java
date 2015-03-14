/*
 Copyright 2015 Clément Bizeau

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package org.clebi.mandrill.model;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Status of a sent message
 */
public class MessageStatus {

    public static final String STATUS_SENT = "sent";
    public static final String STATUS_QUEUED = "queued";
    public static final String STATUS_SCHEDULED = "scheduled";
    public static final String STATUS_REJECTED = "rejected";
    public static final String STATUS_INVALID = "invalid";

    private final String _id;
    private final String status;
    private final String email;
    private final String reject_reason;

    /**
     * create message status
     * @param _id id of the message
     * @param status status of the message
     * @param email reccipient email
     * @param reject_reason why the mail was rejected
     */
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

    public String getId() {
        return _id;
    }

    public String getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public String getReject_reason() {
        return reject_reason;
    }

    @Override
    public String toString() {
        return "MessageStatus{" + "_id=" + _id + ", status=" + status + ", email=" + email + ", reject_reason="
                + reject_reason + '}';
    }

}
