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

public class MandrillApi {

    private final String api_url;
    private final String api_key;

    /**
     * create Mandrill api
     * @param api_url url of the mandrill api
     * @param api_key key of the mandrill api
     */
    public MandrillApi(String api_url, String api_key) {
        this.api_url = api_url;
        this.api_key = api_key;
    }

    public String getApi_key() {
        return api_key;
    }

    public String getApi_url() {
        return api_url;
    }

}
