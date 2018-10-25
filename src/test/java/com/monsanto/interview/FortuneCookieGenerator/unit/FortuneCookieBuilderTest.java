package com.monsanto.interview.FortuneCookieGenerator.unit;

import com.monsanto.interview.FortuneCookieGenerator.FortuneCookie;
import com.monsanto.interview.FortuneCookieGenerator.FortuneCookieBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FortuneCookieBuilderTest {

    @Test
    public void shouldGenerateMsgs() {
        final String first = "A";
        final String firstExpectedMessage = String.format(FortuneCookieBuilder.MSG_TMPL, first, first, first);

        final FortuneCookieBuilder fortuneCookieBuilder = new FortuneCookieBuilder();

        final FortuneCookie firstResult = fortuneCookieBuilder
                .withClient(first)
                .withCompany(first)
                .withQuote(first)
                .build();

        assertEquals(firstExpectedMessage, firstResult.getMessage());
    }

}
