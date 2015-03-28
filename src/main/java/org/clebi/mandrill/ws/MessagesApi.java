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

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.clebi.mandrill.model.messages.MessageStatus;
import org.clebi.mandrill.model.messages.SendTemplateRequest;
import org.clebi.mandrill.model.messages.MergeVar;
import org.clebi.mandrill.model.messages.Message;
import org.clebi.mandrill.model.messages.SendMessageRequest;
import java.util.List;

import org.clebi.mandrill.exception.MandrillApiException;

/**
 * Mandrill Messages Api
 */
public class MessagesApi extends MandrillApi {

    private static final String PATH_API = "/messages/";
    private static final String PATH_SEND = "send.json";
    private static final String PATH_SEND_TEMPLATE = "send-template.json";

    /**
     * create messages api
     *
     * @param api_url url of the mandrill api
     * @param api_key key of the mandrill api
     */
    public MessagesApi(String api_url, String api_key) {
        super(api_url, api_key, PATH_API, JacksonJsonProvider.class);
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
        return execute(PATH_SEND, request, MessageStatus[].class);
    }

    public MessageStatus[] sendTemplate(String template,
                                        List<MergeVar<String>> template_content,
                                        Message message,
                                        boolean async) throws MandrillApiException {
        SendTemplateRequest request = new SendTemplateRequest(template, template_content, getApi_key(), message, async);
        return execute(PATH_SEND_TEMPLATE, request, MessageStatus[].class);
    }

}
