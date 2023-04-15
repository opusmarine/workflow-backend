package com.opus.workflow.repository;

import com.opus.workflow.models.Foglio;
import com.opus.workflow.projections.LottosOnly;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoglioRepository extends JpaRepository<Foglio, Long> {
    List<Foglio> findAllByMonolotto(String monolotto);
    List<LottosOnly> findAllLottosByMonolotto(String monolotto);
    List<LottosOnly> findAllLottosByMonolottoAndDestinatary(String monolotto, String destinatary);
    List<Foglio> findAllFogliosByMonolottoAndDestinatary(String monolotto, String destinatary);

}
