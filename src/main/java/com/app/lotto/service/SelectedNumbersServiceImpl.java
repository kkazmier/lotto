package com.app.lotto.service;

import com.app.lotto.repository.SelectedNumbers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class SelectedNumbersServiceImpl implements SelectedNumbersService{
    private final SelectedNumbersService service;

    @Override
    public List<SelectedNumbers> getAll() {
        return service.getAll();
    }

    @Override
    public SelectedNumbers save(SelectedNumbers numbers) {
        return service.save(numbers);
    }
}
