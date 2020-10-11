package com.app.lotto.service;

import com.app.lotto.repository.SelectedNumbers;
import com.app.lotto.repository.SelectedNumbersRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class SelectedNumbersServiceImpl implements SelectedNumbersService{
    private final Logger logger = LoggerFactory.getLogger(SelectedNumbersServiceImpl.class);
    private final SelectedNumbersRepository repository;

    @Override
    public List<SelectedNumbers> getAll() {
        return repository.findAll();
    }

    @Override
    public SelectedNumbers save(SelectedNumbers numbers) {
        return repository.save(numbers);
    }

    @Override
    public SelectedNumbers save(String gameType, String numbers) {
        SelectedNumbers selectedNumbers = new SelectedNumbers();
        selectedNumbers.setGameType(gameType);
        selectedNumbers.setNumbers(numbers);
        selectedNumbers.setCreatedTime(LocalDateTime.now());
        logger.info(selectedNumbers.toString());
        return repository.save(selectedNumbers);
    }
}
