package com.bs.controller;

import com.bs.service.VersusCursosService;
import com.dto.VersusCursosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/18/17
 */
@RestController
@RequestMapping("/versusCursos")
public class VersusCursosController {

    private VersusCursosService versusCursosService;

   @Autowired
    public VersusCursosController(VersusCursosService versusCursosService) {
        Assert.notNull(versusCursosService, "versusCursosService no debe ser null");
        this.versusCursosService = versusCursosService;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/graba")
    public ResponseEntity<Boolean> cambioDeTurno(@RequestBody List<VersusCursosDTO> request) {
        return new ResponseEntity<>(versusCursosService.grabaVersusCursos(request), HttpStatus.OK);
    }
}
