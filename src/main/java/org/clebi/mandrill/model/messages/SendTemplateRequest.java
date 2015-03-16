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

package org.clebi.mandrill.model.messages;

import java.util.LinkedList;
import java.util.List;

/**
 * Send message template request
 */
public class SendTemplateRequest extends SendMessageRequest {

    private String template_name;
    
    private List<MergeVar<String>> template_content;

    public SendTemplateRequest(String template_name, String key, Message message, boolean async) {
        super(key, message, async);
        this.template_name = template_name;
        this.template_content = new LinkedList<>();
    }

    public SendTemplateRequest(String template_name, List<MergeVar<String>> template_content, String key, Message message, boolean async) {
        super(key, message, async);
        this.template_name = template_name;
        this.template_content = template_content;
    }

    public String getTemplate_name() {
        return template_name;
    }

    public void setTemplate_name(String template_name) {
        this.template_name = template_name;
    }

    public List<MergeVar<String>> getTemplate_content() {
        return template_content;
    }

    public void setTemplate_content(List<MergeVar<String>> template_content) {
        this.template_content = template_content;
    }
    
    public void addTemplateContent(MergeVar<String> var) {
        template_content.add(var);
    }

}
