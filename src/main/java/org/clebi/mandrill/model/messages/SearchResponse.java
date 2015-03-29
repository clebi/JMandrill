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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.List;

/**
 * Search response
 */
@JsonIgnoreProperties({"resends"})
public class SearchResponse {

    private final int ts;

    private final String id;

    private final String sender;

    private final String template;

    private final String subject;

    private final String email;

    private final List<String> tags;

    private final int opens;

    private final List<OpenDetail> opensDetail;

    private final int clicks;

    private final List<ClickDetail> clicksDetail;

    private final String state;
    
    private final List<SmtpEvent> smtpEvents;
    
    private final String subaccount;
    
    private final String reject;

    private final HashMap<String, String> metadata;

    @JsonCreator
    public SearchResponse(
            @JsonProperty("ts") int ts,
            @JsonProperty("_id") String id,
            @JsonProperty("sender") String sender,
            @JsonProperty("template") String template,
            @JsonProperty("subject") String subject,
            @JsonProperty("email") String email,
            @JsonProperty("tags") List<String> tags,
            @JsonProperty("opens") int opens,
            @JsonProperty("opens_detail") List<OpenDetail> opensDetail,
            @JsonProperty("clicks") int clicks,
            @JsonProperty("clicks_detail") List<ClickDetail> clicksDetail,
            @JsonProperty("state") String state,
            @JsonProperty("smtp_events") List<SmtpEvent> smtpEvents,
            @JsonProperty("subaccount") String subaccount,
            @JsonProperty("reject") String reject,
            @JsonProperty("metadata") HashMap<String, String> metadata) {
        this.ts = ts;
        this.id = id;
        this.sender = sender;
        this.template = template;
        this.subject = subject;
        this.email = email;
        this.tags = tags;
        this.opens = opens;
        this.opensDetail = opensDetail;
        this.clicks = clicks;
        this.clicksDetail = clicksDetail;
        this.state = state;
        this.smtpEvents = smtpEvents;
        this.subaccount = subaccount;
        this.reject = reject;
        this.metadata = metadata;
    }

    public int getTs() {
        return ts;
    }

    public String getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getTemplate() {
        return template;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getTags() {
        return tags;
    }

    public int getOpens() {
        return opens;
    }

    public List<OpenDetail> getOpensDetail() {
        return opensDetail;
    }

    public int getClicks() {
        return clicks;
    }

    public List<ClickDetail> getClicksDetail() {
        return clicksDetail;
    }

    public String getState() {
        return state;
    }

    public List<SmtpEvent> getSmtpEvents() {
        return smtpEvents;
    }

    public String getSubaccount() {
        return subaccount;
    }

    public String getReject() {
        return reject;
    }

    public HashMap<String, String> getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return "SearchResponse{" + "ts=" + ts + ", id=" + id + ", sender=" + sender + ", template=" + template
                + ", subject=" + subject + ", email=" + email + ", tags=" + tags + ", opens=" + opens + ", opensDetail="
                + opensDetail + ", clicks=" + clicks + ", clicksDetail=" + clicksDetail + ", state=" + state
                + ", metadata=" + metadata + '}';
    }

}
