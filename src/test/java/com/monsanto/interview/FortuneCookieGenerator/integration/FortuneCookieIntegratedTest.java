package com.monsanto.interview.FortuneCookieGenerator.integration;

import com.monsanto.interview.FortuneCookieGenerator.FortuneCookieBuilder;
import com.monsanto.interview.FortuneCookieGenerator.FortuneCookieController;
import com.monsanto.interview.FortuneCookieGenerator.QuoteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Be careful! Running the Default App Context (any external interaction could fail)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FortuneCookieIntegratedTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @InjectMocks
    private FortuneCookieController controller;

    @MockBean
    private QuoteRepository quoteRepository;

    @Test
    public void shouldBeDifferentMessage() throws Exception {
        final String someClientOne = "someClientOne";
        final String someCompanyOne = "someCompanyOne";
        final String quoteOne = "quoteOne";
        final String msgOne = String.format(FortuneCookieBuilder.MSG_TMPL, someClientOne, someCompanyOne, quoteOne);

        final String someClientTwo = "someClient2";
        final String someCompanyTwo = "comeCompany2";
        final String quoteTow = "be happy";
        final String msgTwo = String.format(FortuneCookieBuilder.MSG_TMPL, someClientTwo, someCompanyTwo, quoteTow);

        when(quoteRepository.getRandomQuote()).thenReturn(quoteOne).thenReturn(quoteTow);

        final String httpUrl = "http://localhost:" + port + "/generateFortuneCookie";

        final String fullUri1 = UriComponentsBuilder.fromHttpUrl(httpUrl)
                .queryParam("client", someClientOne)
                .queryParam("company", someCompanyOne)
                .toUriString();

        final String fullUri2 = UriComponentsBuilder.fromHttpUrl(httpUrl)
                .queryParam("client", someClientTwo)
                .queryParam("company", someCompanyTwo)
                .toUriString();

        final HttpEntity<Response> result1 = restTemplate.exchange(fullUri1,
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                Response.class);
        final HttpEntity<Response> result2 = restTemplate.exchange(fullUri2,
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                Response.class);

        assertEquals(msgOne, result1.getBody().getMessage());
        assertEquals(msgTwo, result2.getBody().getMessage());
    }

}
