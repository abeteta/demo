package com.bs.controller;

import com.bo.HistoricoVersus;
import com.bs.service.HistoricoVersusService;
import com.dto.RespuestaRequestDTO;
import com.dto.RespuestaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/9/17
 */
@RestController
@RequestMapping("/historicoVersus")
public class HistoricoVersusController {
    private HistoricoVersusService HistoricoVersusService;

    @Autowired
    public HistoricoVersusController(HistoricoVersusService HistoricoVersusService) {
        Assert.notNull(HistoricoVersusService, "HistoricoVersusService no debe ser null");
        this.HistoricoVersusService = HistoricoVersusService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/grabaRespuesta")
    public ResponseEntity<RespuestaResponseDTO> grabaRespuesta(@RequestBody RespuestaRequestDTO request) {
        return new ResponseEntity<>(HistoricoVersusService.grabaRespuesta(request), HttpStatus.OK);
    }

}
