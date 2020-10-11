package com.app.lotto.controller;

import com.app.lotto.repository.SelectedNumbers;
import com.app.lotto.service.SelectedNumbersService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class SelectedNumbersController {
    private final Logger logger = LoggerFactory.getLogger(SelectedNumbersController.class);
    private final SelectedNumbersService service;

    @GetMapping(value = "all")
    List<SelectedNumbers> getAll(){
        return service.getAll();
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public SelectedNumbers createNumbers(@RequestBody SelectedNumbers numbers){
        logger.info("Add " + numbers);
        return service.save(numbers);
    }

    @PostMapping(value = "create/{gameType}/{numbers}")
    public SelectedNumbers createNumbers(
            @PathVariable("gameType") String gameType,
            @PathVariable("numbers") String numbers){
        return service.save(gameType, numbers);
    }
}
