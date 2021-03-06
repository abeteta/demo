package com.bs.controller;

import com.bs.service.VersusService;
import com.dto.EsperandoOponenteDTO;
import com.dto.VersusCursosDTO;
import com.dto.VersusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/5/17
 */
@RestController
@RequestMapping("/versus")
public class VersusController {
    private VersusService versusService;

    @Autowired
    public VersusController(VersusService versusService) {
        Assert.notNull(versusService, "versusService no debe ser null");
        this.versusService = versusService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/grabaQuiz")
    public ResponseEntity<VersusDTO> grabaQuiz(@RequestBody VersusDTO request) {
        return new ResponseEntity<>(versusService.grabaQuiz(request), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/buscarQuiz")
    public ResponseEntity<VersusDTO> buscaQuiz(@RequestBody VersusDTO request) {
        return new ResponseEntity<>(versusService.buscarQuiz(request), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/buscarOponente")
    public ResponseEntity<Integer> buscaOponente(@RequestBody VersusDTO request) {
        return new ResponseEntity<>(versusService.buscaOponente(request), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/buscarTurnoPrimerJugador")
    public ResponseEntity<Boolean> buscarTurnoPrimerJugador(@RequestBody VersusDTO request) {
        return new ResponseEntity<>(versusService.buscarTurnoPrimerJugador(request), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/buscarTurnoSegundoJugador")
    public ResponseEntity<Boolean> buscarTurnoSegundoJugador(@RequestBody VersusDTO request) {
        return new ResponseEntity<>(versusService.buscarTurnoSegundoJugador(request), HttpStatus.OK);
    }

/*    @RequestMapping(method = RequestMethod.GET, value = "/cambioDeTurno")
    public ResponseEntity<Boolean> cambioDeTurno(int id) {
        return new ResponseEntity<>(versusService.cambioDeTurno(id), HttpStatus.OK);
    }*/

    @RequestMapping(method = RequestMethod.POST, value = "/cambioDeTurno")
    public ResponseEntity<Boolean> cambioDeTurno(@RequestBody VersusDTO versus) {
        return new ResponseEntity<>(versusService.cambioDeTurno(versus), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/finalizaQuiz")
    public ResponseEntity<Boolean> finalizaQuiz(@PathVariable("id_versus") int id) {
        return new ResponseEntity<>(versusService.finalizaQuiz(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/esperandoOponente")
    public ResponseEntity<List<VersusCursosDTO>> cambioDeTurno(@RequestBody EsperandoOponenteDTO oponente) {
        return new ResponseEntity<>(versusService.esperandoOponente(oponente), HttpStatus.OK);
    }

}
