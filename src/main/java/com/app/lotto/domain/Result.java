package com.app.lotto.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    private LocalDateTime drawDate;
    private Integer drawSystemId;
    private String gameType;
    private List numbers = new ArrayList();

    @Override
    public String toString() {
        return "Result{" +
                "drawDate=" + drawDate +
                ", drawSystemId=" + drawSystemId +
                ", gameType='" + gameType + '\'' +
                ", numbers=" + numbers +
                '}';
    }
}
