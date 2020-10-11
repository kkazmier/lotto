package com.app.lotto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SelectedNumbersRepository extends CrudRepository<SelectedNumbers, Long> {
    List<SelectedNumbers> findAll();
    SelectedNumbers save(SelectedNumbers numbers);
}
