package com.app.lotto.service;

import com.app.lotto.repository.SelectedNumbers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SelectedNumbersService {
    List<SelectedNumbers> getAll();
    SelectedNumbers save(SelectedNumbers numbers);
}
