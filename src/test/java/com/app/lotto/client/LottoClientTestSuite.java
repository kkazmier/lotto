package com.app.lotto.client;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class LottoClientTestSuite {
    private Logger logger = LoggerFactory.getLogger(LottoClientTestSuite.class);

    @Test
    void testUriComponentsBuilder() {
        URI url = UriComponentsBuilder.fromHttpUrl("https://test/com")
                .queryParam("key1", "value1")
                .queryParam("key2", "value2")
                .build().encode().toUri();

        assertNotNull(url);
        assertEquals("https://test/com?key1=value1&key2=value2", url.toString());
        logger.info(url.toString());
    }
}
