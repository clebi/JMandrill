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

package org.clebi.mandrill.model.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * click detail
 */
public class ClickDetail {

    private final long ts;

    private final String url;

    private final String ip;

    private final String location;

    private final String ua;

    /**
     * create a click detail
     * @param ts click timestamp
     * @param url clicked url
     * @param ip click ip
     * @param location click location
     * @param ua browser information
     */
    public ClickDetail(
            @JsonProperty("ts") long ts,
            @JsonProperty("url") String url,
            @JsonProperty("ip") String ip,
            @JsonProperty("location") String location,
            @JsonProperty("ua") String ua) {
        this.ts = ts;
        this.url = url;
        this.ip = ip;
        this.location = location;
        this.ua = ua;
    }

    public long getTs() {
        return ts;
    }

    public String getUrl() {
        return url;
    }

    public String getIp() {
        return ip;
    }

    public String getLocation() {
        return location;
    }

    public String getUa() {
        return ua;
    }

}
