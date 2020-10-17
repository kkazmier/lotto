package com.app.lotto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface SelectedNumbersRepository extends CrudRepository<SelectedNumbers, Long> {
    List<SelectedNumbers> findAll();

    @Query(nativeQuery = true,
            value = "select * from SelectedNumbers where createdTime between :start and :end")
    List<SelectedNumbers> findAllFromGivenInterval(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    SelectedNumbers save(SelectedNumbers numbers);
}
