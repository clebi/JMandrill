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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Message search request
 */
public class SearchRequest {

    @JsonProperty("key")
    private String key;

    @JsonProperty("query")
    private String query;

    @JsonProperty("date_from")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateFrom;

    @JsonProperty("date_to")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateTo;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("senders")
    private List<String> senders;

    @JsonProperty("api_keys")
    private List<String> apiKeys;

    @JsonProperty("limit")
    private int limit;

    /**
     * create a search request
     *
     * @param key api key
     * @param query query string, take a look at mandrill query language
     * @param dateFrom search from date
     * @param dateTo search to date
     * @param limit maximum number of result
     */
    public SearchRequest(String key, String query, Date dateFrom, Date dateTo, int limit) {
        this.key = key;
        this.query = query;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.tags = new LinkedList<>();
        this.senders = new LinkedList<>();
        this.apiKeys = new LinkedList<>();
        this.limit = limit;
    }

    /**
     * create a search request
     *
     * @param key api key
     * @param query query string, take a look at mandrill query language
     * @param dateFrom search from date
     * @param dateTo search to date
     * @param tags list of tags to narrow the search
     * @param senders list of sender to narrow the search
     * @param apiKeys list of api keys to narrow the search
     * @param limit maximum number of result
     */
    public SearchRequest(String key,
                         String query,
                         Date dateFrom,
                         Date dateTo,
                         List<String> tags,
                         List<String> senders,
                         List<String> apiKeys,
                         int limit) {
        this.key = key;
        this.query = query;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.tags = tags;
        this.senders = senders;
        this.apiKeys = apiKeys;
        this.limit = limit;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getSenders() {
        return senders;
    }

    public void setSenders(List<String> senders) {
        this.senders = senders;
    }

    public List<String> getApiKeys() {
        return apiKeys;
    }

    public void setApiKeys(List<String> apiKeys) {
        this.apiKeys = apiKeys;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public void addSender(String sender) {
        senders.add(sender);
    }

    public void addApiKeys(String api_key) {
        apiKeys.add(api_key);
    }

}
