package com.app.lotto.client;

import com.app.lotto.domain.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

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

    @Autowired
    public LottoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Result getLastResult(String gameType) throws JsonProcessingException {
        Result result = new Result();
        int gamePosition = calculateGamePosition(gameType);
        int numberQuantity = calculateGameNumbersQuantity(gameType);
        //URI url = buildUrl(gameType);
        URI url = URI.create("https://www.lotto.pl/api/lotteries/draw-results/by-gametype?game=Lotto&index=1&size=1&sort=drawDate&order=DESC");
        ResponseEntity<?> response = restTemplate.getForEntity(url, String.class);
        logger.info(response.getStatusCode().toString());
        JsonNode resultNode = new ObjectMapper().readTree(response.getBody().toString());

        result.setDrawDate(LocalDateTime.parse(resultNode.get("items").get(0).get("results").get(gamePosition).get("drawDate").asText().substring(0, 19)));
        result.setDrawSystemId(resultNode.get("items").get(0).get("results").get(gamePosition).get("drawSystemId").asInt());
        result.setDrawSystemId(resultNode.get("items").get(0).get("results").get(gamePosition).get("drawSystemId").asInt());
        result.setGameType(gameType);
        for (int p = 0; p < numberQuantity; p++){
            result.getNumbers().add(
                    resultNode.get("items").get(0).get("results").get(gamePosition).get("resultsJson").get(p).asInt());
        }

        logger.info(result.toString());
        return result;
    }

    public URI buildUrl(String gameType){
        return UriComponentsBuilder.fromHttpUrl(endpoint)
            .queryParam("game", gameType)
            .queryParam("index", 1)
            .queryParam("size", 1)
            .queryParam("sort", "drawDate")
            .queryParam("order", "DESC")
            .build().encode().toUri();
    }

    public int calculateGamePosition(String gameType){
        int pos = -1;
        switch (gameType){
            case "Lotto": pos = 0;
                break;
            case "LottoPlus": pos = 1;
                break;
            case "SuperSzansa": pos = 2;
                break;
        }
        return pos;
    }

    public int calculateGameNumbersQuantity(String gameType){
        int qty = -1;
        switch (gameType){
            case "Lotto":
            case "LottoPlus":
                qty = 6;
                break;
            case "SuperSzansa": qty = 7;
                break;
        }
        return qty;
    }
}
