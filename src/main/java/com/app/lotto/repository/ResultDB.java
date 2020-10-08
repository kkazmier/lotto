package com.app.lotto.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "result")
public class ResultDB {
    private Long id;
    private LocalDateTime drawDate;
    private Integer drawSystemId;
    private String gameType;
}
