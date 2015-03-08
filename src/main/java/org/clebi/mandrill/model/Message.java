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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Message {

    @JsonProperty("html")
    private String html;

    @JsonProperty("text")
    private String text;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("from_email")
    private String from_email;

    @JsonProperty("from_name")
    private String from_name;

    @JsonProperty("to")
    private List<Recipient> to;

    @JsonProperty("headers")
    private Map<String, String> headers = new HashMap<>();

    @JsonProperty("important")
    private boolean important;

    @JsonProperty("track_opens")
    private boolean track_opens;

    @JsonProperty("track_clicks")
    private boolean track_clicks;

    @JsonProperty("auto_text")
    private boolean auto_text = false;

    @JsonProperty("auto_html")
    private boolean auto_html = false;

    @JsonProperty("inline_css")
    private boolean inline_css = false;

    @JsonProperty("url_strip_qs")
    private boolean url_strip_qs = false;

    @JsonProperty("preserve_recipients")
    private boolean preserve_recipients = false;

    @JsonProperty("view_content_link")
    private boolean view_content_link = false;

    @JsonProperty("bss_adress")
    private String bcc_address;

    @JsonProperty("tracking_domain")
    private String tracking_domain;

    @JsonProperty("signing_domain")
    private String signing_domain;

    @JsonProperty("return_path_domain")
    private String return_path_domain;

    @JsonProperty("merge")
    private boolean merge;

    @JsonProperty("merge_language")
    private String merge_language;

    @JsonProperty("global_merge_vars")
    private List<MergeVar> global_merge_vars = new LinkedList<>();

    @JsonProperty("merge_vars")
    private List<RecipientMergeVar> merge_vars = new LinkedList<>();

    @JsonProperty("tags")
    private List<String> tags = new LinkedList<>();

    public Message(String html,
                   String text,
                   String subject,
                   String from_email,
                   String from_name,
                   List<Recipient> to,
                   boolean important,
                   boolean track_opens,
                   boolean track_clicks) {
        this.html = html;
        this.text = text;
        this.subject = subject;
        this.from_email = from_email;
        this.from_name = from_name;
        this.to = to;
        this.important = important;
        this.track_opens = track_opens;
        this.track_clicks = track_clicks;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFrom_email() {
        return from_email;
    }

    public void setFrom_email(String from_email) {
        this.from_email = from_email;
    }

    public String getFrom_name() {
        return from_name;
    }

    public void setFrom_name(String from_name) {
        this.from_name = from_name;
    }

    public List<Recipient> getTo() {
        return to;
    }

    public void setTo(List<Recipient> to) {
        this.to = to;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public boolean isTrack_opens() {
        return track_opens;
    }

    public void setTrack_opens(boolean track_opens) {
        this.track_opens = track_opens;
    }

    public boolean isTrack_clicks() {
        return track_clicks;
    }

    public void setTrack_clicks(boolean track_clicks) {
        this.track_clicks = track_clicks;
    }

    public boolean isAuto_text() {
        return auto_text;
    }

    public void setAuto_text(boolean auto_text) {
        this.auto_text = auto_text;
    }

    public boolean isAuto_html() {
        return auto_html;
    }

    public void setAuto_html(boolean auto_html) {
        this.auto_html = auto_html;
    }

    public boolean isInline_css() {
        return inline_css;
    }

    public void setInline_css(boolean inline_css) {
        this.inline_css = inline_css;
    }

    public boolean isUrl_strip_qs() {
        return url_strip_qs;
    }

    public void setUrl_strip_qs(boolean url_strip_qs) {
        this.url_strip_qs = url_strip_qs;
    }

    public boolean isPreserve_recipients() {
        return preserve_recipients;
    }

    public void setPreserve_recipients(boolean preserve_recipients) {
        this.preserve_recipients = preserve_recipients;
    }

    public boolean isView_content_link() {
        return view_content_link;
    }

    public void setView_content_link(boolean view_content_link) {
        this.view_content_link = view_content_link;
    }

    public String getBcc_address() {
        return bcc_address;
    }

    public void setBcc_address(String bcc_address) {
        this.bcc_address = bcc_address;
    }

    public String getTracking_domain() {
        return tracking_domain;
    }

    public void setTracking_domain(String tracking_domain) {
        this.tracking_domain = tracking_domain;
    }

    public String getSigning_domain() {
        return signing_domain;
    }

    public void setSigning_domain(String signing_domain) {
        this.signing_domain = signing_domain;
    }

    public String getReturn_path_domain() {
        return return_path_domain;
    }

    public void setReturn_path_domain(String return_path_domain) {
        this.return_path_domain = return_path_domain;
    }

    public boolean isMerge() {
        return merge;
    }

    public void setMerge(boolean merge) {
        this.merge = merge;
    }

    public String getMerge_language() {
        return merge_language;
    }

    public void setMerge_language(String merge_language) {
        this.merge_language = merge_language;
    }

    public List<MergeVar> getGlobal_merge_vars() {
        return global_merge_vars;
    }

    public void setGlobal_merge_vars(List<MergeVar> global_merge_vars) {
        this.global_merge_vars = global_merge_vars;
    }

    public List<RecipientMergeVar> getMerge_vars() {
        return merge_vars;
    }

    public void setMerge_vars(List<RecipientMergeVar> merge_vars) {
        this.merge_vars = merge_vars;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
