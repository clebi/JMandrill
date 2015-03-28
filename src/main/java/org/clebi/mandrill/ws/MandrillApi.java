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

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.clebi.mandrill.exception.MandrillApiException;
import org.clebi.mandrill.model.ApiError;

/**
 * basic mandrill api
 */
public class MandrillApi {

    private final String api_url;
    private final String api_key;
    private final String api_path;

    private final Client httpClient;
    private final WebTarget target;

    /**
     * create Mandrill api
     *
     * @param api_url url of the mandrill api
     * @param api_key key of the mandrill api
     * @param api_path path of the concerned api
     * @param clazz deserializer class
     */
    public MandrillApi(String api_url, String api_key, String api_path, Class clazz) {
        this.api_url = api_url;
        this.api_key = api_key;
        this.api_path = api_path;
        this.httpClient = ClientBuilder.newClient();
        this.httpClient.register(clazz);
        this.target = this.httpClient.target(this.api_url).path(api_path);
    }

    public <T> T execute(String call, Object request, Class<T> clazz) throws MandrillApiException {
        Response resp = target.path(call).request().post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE));
        if (resp.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL) {
            throw new MandrillApiException("unable to execute " + api_path + call, resp.readEntity(ApiError.class));
        }
        return resp.readEntity(clazz);
    }

    public String getApi_key() {
        return api_key;
    }

    public String getApi_url() {
        return api_url;
    }

}
