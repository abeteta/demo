package com.bs.service;

import com.bo.Pregunta;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 10/28/17
 */
public interface PreguntasService {
    //List<Pregunta> findAll();
    List<Pregunta> findPreguntas(List<Integer> curso);
}
