package com.bs.service;

import com.bo.Dificultad;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/18/17
 */
public interface DificultadService {
    List<Dificultad> findAll();
    Dificultad findOne(Integer id_curso);
}
