package com.bs.controller;

import com.bo.Curso;
import com.bo.Pregunta;
import com.bs.service.PreguntasService;
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
 * created on 10/29/17
 */
@RestController
@RequestMapping("/preguntas")
public class PreguntasController {

    private PreguntasService preguntasService;

    @Autowired
    public PreguntasController(PreguntasService preguntasService) {
        Assert.notNull(preguntasService, "PreguntasService no debe ser null");
        this.preguntasService = preguntasService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/listadoSeleccionado")
    public ResponseEntity<List<Pregunta>> listaCursos(@RequestBody List<Integer> listado) {
        return new ResponseEntity<>(preguntasService.findPreguntas(listado), HttpStatus.OK);
    }

}
