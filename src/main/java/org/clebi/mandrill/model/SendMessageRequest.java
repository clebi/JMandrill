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

import java.util.Date;

/**
 * Send message request
 */
public class SendMessageRequest extends ApiRequest {

    @JsonProperty("message")
    private Message message;

    @JsonProperty("async")
    private boolean async;

    @JsonProperty("ip_pool")
    private String ip_pool;

    @JsonProperty("send_at")
    private Date send_at;

    /**
     * create a request to send a message
     *
     * @param key api key
     * @param message message to be send
     * @param async asynchrone sending
     */
    public SendMessageRequest(String key, Message message, boolean async) {
        super(key);
        this.message = message;
        this.async = async;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public boolean isAsync() {
        return async;
    }

    public void setAsync(boolean async) {
        this.async = async;
    }

    public String getIp_pool() {
        return ip_pool;
    }

    public void setIp_pool(String ip_pool) {
        this.ip_pool = ip_pool;
    }

    public Date getSend_at() {
        return send_at;
    }

    public void setSend_at(Date send_at) {
        this.send_at = send_at;
    }

}
