package com.opus.workflow.service;

import com.opus.workflow.models.Foglio;
import com.opus.workflow.models.Lotto;
import com.opus.workflow.projections.LottosOnly;
import com.opus.workflow.repository.FoglioRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FoglioService {
    private final FoglioRepository foglioRepository;

    public FoglioService(FoglioRepository foglioRepository) {
        this.foglioRepository = foglioRepository;
    }

    public List<Foglio> getAllFoglios() {
        return foglioRepository.findAll();
    }

    public Foglio addFoglio(Foglio inputFoglio) {
//        inputFoglio.setLottoId(inputFoglio.getLottos(), inputFoglio.getId());
//        foglioRepository.G
        foglioRepository.save(inputFoglio);/**/
        return inputFoglio;
    }

    public List<Foglio> searchFoglioByMonolotto(String monolotto) {
        return foglioRepository.findAllByMonolotto(monolotto);
    }

    public List<LottosOnly> searchLottosByMonolotto(String monolotto) {
        return foglioRepository.findAllLottosByMonolotto(monolotto);
    }

    public List<LottosOnly> serachLottosByMonolottoAndDestinatary(String monolotto, String destinatary) {
        List<LottosOnly> lottos =
                Optional.ofNullable(foglioRepository.findAllLottosByMonolottoAndDestinatary(monolotto, destinatary))
                        .orElseThrow(() -> new IllegalStateException(String.format("[INFO] Monolotto: '%s' with destinatary: '%s' doesn't exist.", monolotto, destinatary )));
        return lottos;
    }

    public Integer lottosQuantityCount(String monolotto, String destinatary) {
        Integer qtyCount = 0;
        List<Foglio> foglios =
                Optional.ofNullable(foglioRepository.findAllFogliosByMonolottoAndDestinatary(monolotto, destinatary))
                        .orElseThrow(() -> new IllegalStateException(String.format("[INFO] Monolotto: '%s' with destinatary: '%s' doesn't exist.", monolotto, destinatary)));

        for(Foglio foglio : foglios) {
            for(Lotto lotto : foglio.getLottos()) {
                qtyCount += lotto.getQty();
            }
        }

        return qtyCount;
    }
}
