package com.app.lotto.controller;

import com.app.lotto.client.LottoClient;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("")
@NoArgsConstructor
public class LottoController {
    private final Logger logger = LoggerFactory.getLogger(LottoController.class);

    private LottoClient lottoClient;

    @Autowired
    public LottoController(LottoClient lottoClient) {
        this.lottoClient = lottoClient;
    }

    @GetMapping("getLastResult")
    public void getLastResult(){
        logger.info("getLastResult");
        logger.info(lottoClient.getEndpoint());
        logger.info(lottoClient.getLastResult("Lotto").toString());
    }
}
