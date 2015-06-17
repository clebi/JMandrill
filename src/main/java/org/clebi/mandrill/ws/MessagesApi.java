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
import javax.ws.rs.core.MediaType;
import java.util.Date;

import org.clebi.mandrill.exception.MandrillApiException;
import org.clebi.mandrill.model.messages.SearchRequest;
import org.clebi.mandrill.model.messages.SearchResponse;

/**
 * Mandrill Messages Api
 */
public class MessagesApi extends MandrillApi {

    private static final String PATH_API = "/messages/";
    private static final String PATH_SEND = "send.json";
    private static final String PATH_SEND_TEMPLATE = "send-template.json";
    private static final String PATH_SEARCH = "search.json";

    /**
     * create messages api
     *
     * @param api_url url of the mandrill api
     * @param api_key key of the mandrill api
     */
    public MessagesApi(String api_url, String api_key) {
        super(api_url, api_key, PATH_API, JacksonJsonProvider.class, MediaType.APPLICATION_JSON_TYPE);
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

    /**
     * send a message using a template
     * @param template template name
     * @param template_content mailchimp content block
     * @param message Message to be sent (html and text could be empty in this one)
     * @param async asynchrone sending
     * @return statuses of the sent messages
     * @throws MandrillApiException an error happened during api call
     */
    public MessageStatus[] sendTemplate(String template,
                                        List<MergeVar<String>> template_content,
                                        Message message,
                                        boolean async) throws MandrillApiException {
        SendTemplateRequest request = new SendTemplateRequest(template, template_content, getApi_key(), message, async);
        return execute(PATH_SEND_TEMPLATE, request, MessageStatus[].class);
    }

    /**
     * execute search query
     *
     * @param query query string, take a look at mandrill query language
     * @param dateFrom search from date
     * @param dateTo search to date
     * @param tags list of tags to narrow the search
     * @param senders list of sender to narrow the search
     * @param apiKeys list of api keys to narrow the search
     * @param limit maximum number of result
     * @return list of search response
     * @throws MandrillApiException
     */
    public SearchResponse[] search(String query,
                                   Date dateFrom,
                                   Date dateTo,
                                   List<String> tags,
                                   List<String> senders,
                                   List<String> apiKeys,
                                   int limit) throws MandrillApiException {
        SearchRequest request = new SearchRequest(getApi_key(), query, dateFrom, dateTo, tags, senders, apiKeys, limit);
        return execute(PATH_SEARCH, request, SearchResponse[].class);
    }

}
