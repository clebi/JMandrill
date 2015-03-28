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
import org.clebi.mandrill.exception.MandrillApiException;
import org.clebi.mandrill.model.users.Ping2Request;
import org.clebi.mandrill.model.users.Ping2Response;

/**
 * Mandrill users api
 */
public class Users extends MandrillApi {

    private static final String PATH_API = "/users/";
    private static final String PATH_PING2 = "ping2.json";

    public Users(String api_url, String api_key) {
        super(api_url, api_key, PATH_API, JacksonJsonProvider.class);
    }

    public Ping2Response ping2() throws MandrillApiException {
        Ping2Request request = new Ping2Request(getApi_key());
        return execute(PATH_PING2, request, Ping2Response.class);
    }

}
