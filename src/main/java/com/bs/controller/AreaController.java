package com.bs.controller;

import com.bo.Area;
import com.bs.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 10/20/17
 */
@RestController
@RequestMapping("/area")
public class AreaController {

    private AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService) {
        Assert.notNull(areaService, "areaService no debe ser null");
        this.areaService = areaService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<List<Area>> listaArea() {
        return new ResponseEntity<>(areaService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id_area}")
    public ResponseEntity<Area> findOne(@PathVariable("id_area") int id) {
        return new ResponseEntity<>(areaService.findOne(id), HttpStatus.OK);
    }
}
