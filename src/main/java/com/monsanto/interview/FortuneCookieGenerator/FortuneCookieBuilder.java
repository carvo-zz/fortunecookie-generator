package com.monsanto.interview.FortuneCookieGenerator;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FortuneCookieBuilder {

    public static final String MSG_TMPL = "Hi %s! Thanks for buying at %s :) And remember: %s";

    private static final String NOT_DEFINED = "N/A";

    private String client = NOT_DEFINED;
    private String company = NOT_DEFINED;
    private String quote = NOT_DEFINED;

    public FortuneCookieBuilder withClient(String client) {
        // if clause removed: spring components holds the last value (second execution isn't N/A)
        this.client = client;
        return this;
    }

    public FortuneCookieBuilder withCompany(String company) {
        // if clause removed: spring components holds the last value (second execution isn't N/A)
        this.company = company;
        return this;
    }

    public FortuneCookieBuilder withQuote(String quote) {
        // if clause removed: spring components holds the last value (second execution isn't N/A)
        this.quote = quote;
        return this;
    }

    public FortuneCookie build() {
        return new FortuneCookie(String.format(MSG_TMPL, client, company, quote));
    }

}
