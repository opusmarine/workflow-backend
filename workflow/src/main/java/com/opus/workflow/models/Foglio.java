package com.opus.workflow.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Foglio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String monolotto;
    private String destinatary;

    @Transient
    private LocalDateTime dateCreated = LocalDateTime.now();

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Lotto> lottos = new ArrayList<>();


    public void setLottoId(List<Lotto> lotto, Long id) {
        for (var x : lotto) {
            x.setId(id);
        }
    }
}
