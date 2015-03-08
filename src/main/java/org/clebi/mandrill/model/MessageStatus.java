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
