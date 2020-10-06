package com.app.lotto.client;

import com.app.lotto.domain.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
public class LottoClient {
    private final Logger logger = LoggerFactory.getLogger(LottoClient.class);

    @Value("${lotto.api.endpoint}")
    private String endpoint;

    private String gameType;

    private RestTemplate restTemplate;

    public Result[] getLastResult(String gameType){
        URI url = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("game", gameType)
                .queryParam("index", 1)
                .queryParam("size", 1)
                .queryParam("sort", "drawDate")
                .queryParam("order", "DESC")
                .build().encode().toUri();
        logger.info(url.toString());
        Result[] response = restTemplate.getForObject(url, Result[].class);
        return response;
    }
}
