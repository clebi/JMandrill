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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Api error
 */
public class ApiError {

    private final String status;
    private final int code;
    private final String name;
    private final String message;

    /**
     * create an api error
     *
     * @param status api return status
     * @param code code of the error
     * @param name name of the error
     * @param message string message for the error
     */
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
        return "ApiError{" + "status='" + status + '\'' + ", code=" + code + ", name='" + name + '\'' + ", message='"
                + message + '\'' + '}';
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
