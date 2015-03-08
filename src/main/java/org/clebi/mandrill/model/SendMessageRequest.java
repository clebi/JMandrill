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
