package com.bs.service;

import com.bo.Curso;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 10/21/17
 */
public interface CursoService {
    List<Curso> findAll();
    Curso findOne(Integer id_curso);
}
