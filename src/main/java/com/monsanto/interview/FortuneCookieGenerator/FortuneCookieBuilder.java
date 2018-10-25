package com.monsanto.interview.FortuneCookieGenerator;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
// Should be REQUEST type (Components are singleton by default and holds the last value)
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class FortuneCookieBuilder {

    public static final String MSG_TMPL = "Hi %s! Thanks for buying at %s :) And remember: %s";

    private static final String NOT_DEFINED = "N/A";

    private String client = NOT_DEFINED;
    private String company = NOT_DEFINED;
    private String quote = NOT_DEFINED;

    public FortuneCookieBuilder withClient(String client) {
        if (NOT_DEFINED.equals(this.client)) {
            this.client = client;
        }
        return this;
    }

    public FortuneCookieBuilder withCompany(String company) {
        if (NOT_DEFINED.equals(this.company)) {
            this.company = company;
        }
        return this;
    }

    public FortuneCookieBuilder withQuote(String quote) {
        if (NOT_DEFINED.equals(this.quote)) {
            this.quote = quote;
        }
        return this;
    }

    public FortuneCookie build() {
        return new FortuneCookie(String.format(MSG_TMPL, client, company, quote));
    }

}
