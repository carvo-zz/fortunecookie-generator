import com.monsanto.interview.FortuneCookieGenerator.FortuneCookie;
import com.monsanto.interview.FortuneCookieGenerator.FortuneCookieBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FortuneCookieBuilderTest {

    @Test
    public void shouldGenerateDifferentMsgs() {
        final String first = "A";
        final String firstExpectedMessage = String.format(FortuneCookieBuilder.MSG_TMPL, first, first, first);

        final String second = "B";
        final String secondExpectedMessage = String.format(FortuneCookieBuilder.MSG_TMPL, second, second, second);

        final FortuneCookieBuilder fortuneCookieBuilder = new FortuneCookieBuilder();

        final FortuneCookie firstResult = fortuneCookieBuilder
                .withClient(first)
                .withCompany(first)
                .withQuote(first)
                .build();

        final FortuneCookie secondResult = fortuneCookieBuilder
                .withClient(second)
                .withCompany(second)
                .withQuote(second)
                .build();

        assertEquals(firstExpectedMessage, firstResult.getMessage());
        assertEquals(secondExpectedMessage, secondResult.getMessage());

    }

}
