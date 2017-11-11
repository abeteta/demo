package com.bs.controller;

import com.bo.Curso;
import com.bs.service.CursoService;
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
 * created on 10/21/17
 */
@RestController
@RequestMapping("/curso")
public class CursoController {

    private CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        Assert.notNull(cursoService, "cursoService no debe ser null");
        this.cursoService = cursoService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<List<Curso>> listaArea() {
        return new ResponseEntity<>(cursoService.findAll(), HttpStatus.OK);
    }


    /*@RequestMapping(method = RequestMethod.POST, value = "/listadoSeleccionado")
    public ResponseEntity<List<Curso>> listaArea(@RequestBody List<Integer> listado) {
        return new ResponseEntity<>(cursoService.findAll(), HttpStatus.OK);
    } */
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id_curso}")
    public ResponseEntity<Curso> findOne(@PathVariable("id_curso") int id) {
        return new ResponseEntity<>(cursoService.findOne(id), HttpStatus.OK);
    }
}
