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
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import org.clebi.mandrill.exception.MandrillApiException;
import org.clebi.mandrill.model.messages.MergeVar;
import org.clebi.mandrill.model.messages.Message;
import org.clebi.mandrill.model.messages.MessageStatus;
import org.clebi.mandrill.model.messages.Recipient;
import org.clebi.mandrill.model.messages.RecipientMergeVar;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMessagesApi {
    
    private static final String TEST_MESSAGE_SUBJECT = "test";
    
    private static final String TEST_MESSAGE = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" + "<head>\n"
                + "<meta name=\"viewport\" content=\"width=device-width\" />\n"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                + "<title>Actionable emails e.g. reset password</title>\n"
                + "<link href=\"styles.css\" media=\"all\" rel=\"stylesheet\" type=\"text/css\" />\n" + "</head>\n"
                + "\n" + "<body itemscope itemtype=\"http://schema.org/EmailMessage\">\n" + "\n"
                + "<table class=\"body-wrap\">\n" + "\t<tr><td>"
                + "<a href=\"https://mandrillapp.com/api/1.0/\">test</a>" + "</td></tr></table></body></html>";
    
    private static final String TEST_MESSAGE_TXT = "test message";
    
    private Properties config;
    
    @BeforeClass
    public void setUp() throws IOException {
        config = new Properties();
        InputStream configStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        config.load(configStream);
    }

    @Test
    public void testSendOne() throws MandrillApiException {
        List<Recipient> recipients = new LinkedList<>();
        recipients.add(new Recipient(config.getProperty("recipient_email"), config.getProperty("recipient_name"), "to"));
        Message message = new Message(TEST_MESSAGE,
                TEST_MESSAGE_TXT,
                TEST_MESSAGE_SUBJECT,
                config.getProperty("from_email"),
                config.getProperty("from_name"),
                recipients,
                true,
                true,
                true);
        List<MergeVar> mergeVars = new LinkedList<>();
        mergeVars.add(new MergeVar<>("test", 1));
        message.setGlobal_merge_vars(mergeVars);
        List<RecipientMergeVar> rcptsMergeVars = new LinkedList<>();
        RecipientMergeVar rcptMergeVars = new RecipientMergeVar(config.getProperty("recipient_email"));
        rcptMergeVars.addMergeVar(new MergeVar<>("test_var", 3.14));
        rcptsMergeVars.add(rcptMergeVars);
        message.setMerge_vars(rcptsMergeVars);
        message.setTracking_domain("track.clebi.ovh");
        message.setReturn_path_domain("track.clebi.ovh");
        MessageStatus[] statuses = new MessagesApi(config.getProperty("api_url"), config.getProperty("api_key")).send(message, false);
        for (MessageStatus status : statuses) {
            Assert.assertEquals(status.getStatus(), MessageStatus.STATUS_SENT);
        }

    }
    
    @Test
    public void testSendBadRecipient() throws MandrillApiException {
        List<Recipient> recipients = new LinkedList<>();
        recipients.add(new Recipient("bad_recipient", config.getProperty("recipient_name"), "to"));
        Message message = new Message(TEST_MESSAGE,
                TEST_MESSAGE_TXT,
                TEST_MESSAGE_SUBJECT,
                config.getProperty("from_email"),
                config.getProperty("from_name"),
                recipients,
                true,
                true,
                true);
        message.setTracking_domain("track.clebi.ovh");
        message.setReturn_path_domain("track.clebi.ovh");
        MessageStatus[] statuses = new MessagesApi(config.getProperty("api_url"), config.getProperty("api_key")).send(message, false);
        for (MessageStatus status : statuses) {
            Assert.assertEquals(status.getStatus(), MessageStatus.STATUS_INVALID);
        }

    }
    
    @Test(expectedExceptions = MandrillApiException.class, expectedExceptionsMessageRegExp = "unable to send message\\(s\\) - error: Invalid API key")
    public void testSendBadApiKey() throws MandrillApiException {
        List<Recipient> recipients = new LinkedList<>();
        recipients.add(new Recipient(config.getProperty("recipient_email"), config.getProperty("recipient_name"), "to"));
        Message message = new Message(TEST_MESSAGE,
                TEST_MESSAGE_TXT,
                TEST_MESSAGE_SUBJECT,
                config.getProperty("from_email"),
                config.getProperty("from_name"),
                recipients,
                true,
                true,
                true);
        message.setTracking_domain("track.clebi.ovh");
        message.setReturn_path_domain("track.clebi.ovh");
        MessageStatus[] statuses = new MessagesApi(config.getProperty("api_url"), "bad_key").send(message, false);
        for (MessageStatus status : statuses) {
            Assert.assertEquals(status.getStatus(), MessageStatus.STATUS_SENT);
        }

    }
    
    @Test
    public void testSendTemplate() throws MandrillApiException {
        List<Recipient> recipients = new LinkedList<>();
        recipients.add(new Recipient(config.getProperty("recipient_email"), config.getProperty("recipient_name"), "to"));
        Message message = new Message(TEST_MESSAGE,
                TEST_MESSAGE_TXT,
                TEST_MESSAGE_SUBJECT,
                config.getProperty("from_email"),
                config.getProperty("from_name"),
                recipients,
                true,
                true,
                true);
        List<RecipientMergeVar> rcptsMergeVars = new LinkedList<>();
        RecipientMergeVar rcptMergeVars = new RecipientMergeVar(config.getProperty("recipient_email"));
        rcptMergeVars.addMergeVar(new MergeVar<>("test_var", 3.14));
        rcptsMergeVars.add(rcptMergeVars);
        message.setMerge_vars(rcptsMergeVars);
        message.setTracking_domain("track.clebi.ovh");
        message.setReturn_path_domain("track.clebi.ovh");
        List<MergeVar<String>> template_content = new LinkedList<>();
        template_content.add(new MergeVar<>("main", "<h2>Hello, world!</h2>"));
        MessageStatus[] statuses = new MessagesApi(config.getProperty("api_url"), config.getProperty("api_key")).
                sendTemplate("test", template_content, message, false);
        for (MessageStatus status : statuses) {
            Assert.assertEquals(status.getStatus(), MessageStatus.STATUS_SENT);
        }
    }

}
