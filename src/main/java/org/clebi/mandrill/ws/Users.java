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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.clebi.mandrill.exception.MandrillApiException;
import org.clebi.mandrill.model.ApiError;
import org.clebi.mandrill.model.users.Ping2Request;
import org.clebi.mandrill.model.users.Ping2Response;

/**
 * Mandrill users api
 */
public class Users extends MandrillApi {

    private static final String PATH_PING2 = "/users/ping2.json";

    private final Client httpClient = ClientBuilder.newClient().register(JacksonJsonProvider.class);

    public Users(String api_url, String api_key) {
        super(api_url, api_key);
    }

    public Ping2Response ping2() throws MandrillApiException {
        Ping2Request request = new Ping2Request(getApi_key());
        Response resp = httpClient.target(getApi_url()).path(PATH_PING2).request().post(
                Entity.entity(request, MediaType.APPLICATION_JSON_TYPE));
        if(resp.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL) {
            throw new MandrillApiException("unable to send ping2 request", resp.readEntity(ApiError.class));
        }
        return resp.readEntity(Ping2Response.class);
    }

}
