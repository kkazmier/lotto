package com.app.lotto.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SelectedNumbersRepository extends CrudRepository<SelectedNumbers, Long> {
    List<SelectedNumbers> findAll();
    SelectedNumbers save(SelectedNumbers numbers);
}
