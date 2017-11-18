package com.bs.controller;

import com.bo.Curso;
import com.bo.Dificultad;
import com.bs.service.CursoService;
import com.bs.service.DificultadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
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
@RequestMapping("/dificultad")
public class DificultadController {
    private DificultadService dificultadService;

    @Autowired
    public DificultadController(DificultadService dificultadService) {
        Assert.notNull(dificultadService, "dificultadService no debe ser null");
        this.dificultadService = dificultadService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<List<Dificultad>> listaDificultad() {
        return new ResponseEntity<>(dificultadService.findAll(), HttpStatus.OK);
    }
}
