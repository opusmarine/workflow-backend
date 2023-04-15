package com.opus.workflow.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Lottos")
@Getter
@Setter
@AllArgsConstructor
public class Lotto {
    @Id
    @GeneratedValue
    @Column(name = "lotto_id")
    private Long Id;

    private String lotto;
    private Integer qty;

    public Lotto() {

    }
    public Lotto(String lotto, Integer qty) {
        this.lotto = lotto;
        this.qty = qty;
    }
}
