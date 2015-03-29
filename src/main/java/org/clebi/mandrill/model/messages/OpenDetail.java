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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Open detail
 */
public class OpenDetail {

    private final long ts;

    private final String ip;

    private final String location;

    private final String ua;

    /**
     * create open detail
     * @param ts open timestamp
     * @param ip open ip
     * @param location open location
     * @param ua browser information
     */
    @JsonCreator
    public OpenDetail(@JsonProperty("ts") int ts,
                      @JsonProperty("ip") String ip,
                      @JsonProperty("location") String location,
                      @JsonProperty("ua") String ua) {
        this.ts = ts;
        this.ip = ip;
        this.location = location;
        this.ua = ua;
    }

    public long getTs() {
        return ts;
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
