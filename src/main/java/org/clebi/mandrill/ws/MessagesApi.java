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

package org.clebi.mandrill.ws;

import java.util.List;
import org.clebi.mandrill.model.*;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.clebi.mandrill.exception.MandrillApiException;

/**
 * Mandrill Messages Api
 */
public class MessagesApi extends MandrillApi {

    private static final String PATH_SEND = "messages/send.json";
    private static final String PATH_SEND_TEMPLATE = "/messages/send-template.json";

    private final Client httpClient = ClientBuilder.newClient().register(JacksonJsonProvider.class);

    /**
     * create messages api
     *
     * @param api_url url of the mandrill api
     * @param api_key key of the mandrill api
     */
    public MessagesApi(String api_url, String api_key) {
        super(api_url, api_key);
    }

    /**
     * Send a message
     *
     * @param message message to be send
     * @param async asynchrone sending
     * @return statuses of the sent messages
     * @throws org.clebi.mandrill.exception.MandrillApiException an error happened during api call
     */
    public MessageStatus[] send(Message message, boolean async) throws MandrillApiException {
        SendMessageRequest request = new SendMessageRequest(getApi_key(), message, false);
        Response resp = httpClient.target(getApi_url()).path(PATH_SEND).request().post(
                Entity.entity(request, MediaType.APPLICATION_JSON_TYPE));
        if (resp.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL) {
            throw new MandrillApiException("unable to send message(s)", resp.readEntity(ApiError.class));
        }
        return resp.readEntity(MessageStatus[].class);
    }

    public MessageStatus[] sendTemplate(String template, 
                                        List<MergeVar<String>> template_content, 
                                        Message message, 
                                        boolean async) throws MandrillApiException {
        SendTemplateRequest request = new SendTemplateRequest(template, template_content, getApi_key(), message, async);
        Response resp = httpClient.target(getApi_url()).path(PATH_SEND_TEMPLATE).request().post(
                Entity.entity(request, MediaType.APPLICATION_JSON_TYPE));
        if (resp.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL) {
            throw new MandrillApiException("unable to send template message", resp.readEntity(ApiError.class));
        }
        return resp.readEntity(MessageStatus[].class);
    }

}
