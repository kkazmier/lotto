package com.app.lotto.client;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class LottoClient {
    @Value("${lotto.api.endpoint}")
    private String endpoint;

    private String gameType;

    private RestTemplate restTemplate;

}
