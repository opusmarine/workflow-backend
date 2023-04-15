package com.opus.workflow.controller;

import com.opus.workflow.models.Foglio;
import com.opus.workflow.projections.LottosOnly;
import com.opus.workflow.service.FoglioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/foglio_bancale")
public class FoglioController {
    private final FoglioService foglioService;
    public FoglioController(FoglioService foglioService) {
        this.foglioService = foglioService;
    }
    @GetMapping("/template")
    public Foglio getTemplate() {
        Foglio foglio = new Foglio();
//        Lotto l = new Lotto();
//        l.
//        List<Lottos> myLottos = new ArrayList<Lottos>();
//        myLottos.add(new Lottos("10101089-23", 18));
//        foglio.setMonolotto("10101114-23");
//
//        foglio.setLottos(myLottos);
        return foglio;
    }
    @GetMapping("/all")
    public List<Foglio> getAllFoglios() {
        return foglioService.getAllFoglios();
    }
    @GetMapping("/getByMonolotto")
    public List<Foglio> getFoglioByMonolotto(@RequestParam("monolotto") String monolotto) {
        return foglioService.searchFoglioByMonolotto(monolotto);
    }
    @GetMapping(value = "/getbyMonolottoAndDestinatary")
    public List<LottosOnly> getAllQtyByMonolottoAndDestinatary(@RequestParam("monolotto") String monolotto, @RequestParam("destinatary") String destinatary) {
        return foglioService.serachLottosByMonolottoAndDestinatary(monolotto, destinatary);
    }
    @GetMapping("/lottos")
    public List<LottosOnly> getAllLottosByMonolotto(@RequestParam("monolotto") String monolotto ) {
        return foglioService.searchLottosByMonolotto(monolotto);
    }

    @GetMapping(value = "/lottosTotalQuantity")
    public Integer getTotalQuantityOfLottos(@RequestParam String monolotto, @RequestParam String destinatary) {
        return foglioService.lottosQuantityCount(monolotto, destinatary);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Foglio addFoglio(@RequestBody Foglio foglio) {
        return foglioService.addFoglio(foglio);
    }
}
