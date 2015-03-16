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

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.clebi.mandrill.exception.MandrillApiException;
import org.clebi.mandrill.model.users.Ping2Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUsersApi {

    private Properties config;

    @BeforeClass
    public void setUp() throws IOException {
        config = new Properties();
        InputStream configStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        config.load(configStream);
    }

    @Test
    public void testPing2() throws MandrillApiException {
        Ping2Response ping = new Users(config.getProperty("api_url"), config.getProperty("api_key")).ping2();
        Assert.assertEquals(ping.getPing(), "PONG!");
    }

}
