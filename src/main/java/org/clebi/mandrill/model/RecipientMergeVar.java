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

package org.clebi.mandrill.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.LinkedList;
import java.util.List;

/**
 * Per recipient merge var used by template
 */
public class RecipientMergeVar {

    @JsonProperty("rcpt")
    private String rcpt;

    @JsonProperty("vars")
    private List<MergeVar<?>> vars;

    /**
     * create per recipient merge var
     *
     * @param rcpt recipient email
     * @param vars list of merge vars
     */
    public RecipientMergeVar(String rcpt, List<MergeVar<?>> vars) {
        this.rcpt = rcpt;
        this.vars = vars;
    }
    
    public RecipientMergeVar(String rcpt) {
        this.rcpt = rcpt;
        this.vars = new LinkedList<>();
    }

    public String getRcpt() {
        return rcpt;
    }

    public void setRcpt(String rcpt) {
        this.rcpt = rcpt;
    }

    public List<MergeVar<?>> getVars() {
        return vars;
    }

    public void setVars(List<MergeVar<?>> vars) {
        this.vars = vars;
    }
    
    public void addMergeVar(MergeVar var) {
        vars.add(var);
    }
}
