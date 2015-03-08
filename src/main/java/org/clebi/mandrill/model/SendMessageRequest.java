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
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SendMessageRequest extends ApiRequest {

    @JsonProperty("message")
    private Message message;

    @JsonProperty("async")
    private boolean async;

    @JsonProperty("ip_pool")
    private String ip_pool;

    @JsonProperty("send_at")
    private Date send_at;

    public SendMessageRequest(String key, Message message, boolean async) {
        super(key);
        this.message = message;
        this.async = async;
    }

    public static void main(String[] args) {
        try {
            List<Recipient> recipients = new LinkedList<>();
            recipients.add(new Recipient("clement.bizeau4@gmail.com", "clement", "to"));
            SendMessageRequest request = new SendMessageRequest("l4o5GDKUFKNJ1MvDa6Dvpggg",
                                                                new Message("test",
                                                                            "test",
                                                                            "test",
                                                                            "test@clebi.ovh",
                                                                            "test",
                                                                            recipients,
                                                                            false,
                                                                            false,
                                                                            false),
                                                                false);
            String recipient_json = new ObjectMapper().writeValueAsString(request);
            System.out.println(recipient_json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
