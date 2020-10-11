package com.app.lotto.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SelectedNumbers {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "gameType")
    private String gameType;

    @Column(name = "createdTime")
    private LocalDateTime createdTime;

    @Column(name = "numbers")
    private String numbers;

    @Override
    public String toString() {
        return "SelectedNumbers{" +
                "id=" + id +
                ", gameType='" + gameType + '\'' +
                ", createdTime=" + createdTime +
                ", numbers='" + numbers + '\'' +
                '}';
    }
}
