package com.app.lotto.service;

import com.app.lotto.repository.SelectedNumbers;

import java.util.List;

public interface SelectedNumbersService {
    List<SelectedNumbers> getAll();
    SelectedNumbers save(SelectedNumbers numbers);
}
