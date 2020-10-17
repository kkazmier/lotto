package com.app.lotto.service;

import com.app.lotto.repository.SelectedNumbers;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SelectedNumbersService {
    List<SelectedNumbers> getAll();
    List<SelectedNumbers> findAllFromGivenInterval(LocalDateTime start, LocalDateTime end);
    SelectedNumbers save(SelectedNumbers numbers);
    SelectedNumbers save(String gameType, String numbers);
}
