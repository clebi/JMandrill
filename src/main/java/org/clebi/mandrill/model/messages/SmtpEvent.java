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
 * Smtp Event
 */
public class SmtpEvent {

    private final long ts;

    private final String type;

    private final String diag;

    /**
     * create an smtp event
     *
     * @param ts timestamp
     * @param type message state for event
     * @param diag smtp response
     */
    @JsonCreator
    public SmtpEvent(
            @JsonProperty("ts") long ts,
            @JsonProperty("type") String type,
            @JsonProperty("diag") String diag) {
        this.ts = ts;
        this.type = type;
        this.diag = diag;
    }

    public long getTs() {
        return ts;
    }

    public String getType() {
        return type;
    }

    public String getDiag() {
        return diag;
    }

}
