package org.clebi.mandrill.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.LinkedList;
import java.util.List;

public class RecipientMergeVar {

    @JsonProperty("rcpt")
    private String rcpt;

    @JsonProperty("vars")
    private List<MergeVar> vars = new LinkedList<>();

    public RecipientMergeVar(String rcpt, List<MergeVar> vars) {
        this.rcpt = rcpt;
        this.vars = vars;
    }

    public String getRcpt() {
        return rcpt;
    }

    public void setRcpt(String rcpt) {
        this.rcpt = rcpt;
    }

    public List<MergeVar> getVars() {
        return vars;
    }

    public void setVars(List<MergeVar> vars) {
        this.vars = vars;
    }
}
