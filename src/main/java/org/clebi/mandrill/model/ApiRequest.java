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

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * basic api request
 *
 * @author clement
 */
public class ApiRequest {

    /**
     * api key
     */
    @JsonProperty("key")
    private String key;

    public ApiRequest() {
    }

    /**
     * create a basic api request
     *
     * @param key api key
     */
    public ApiRequest(String key) {
        this.key = key;
    }

    /**
     * get api key
     *
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * set api key
     *
     * @param key the key
     */
    public void setKey(String key) {
        this.key = key;
    }
}
