package com.bs.service.impl;

import com.bo.Curso;
import com.bo.Pregunta;
import com.bo.Respuestas;
import com.bs.service.PreguntasService;
import com.repository.ListadoPreguntasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 10/28/17
 */
@Service
public class PreguntasServiceImpl implements PreguntasService{

    private ListadoPreguntasRepository listadoPreguntasRepository;

    @Autowired
    public PreguntasServiceImpl (ListadoPreguntasRepository listadoPreguntasRepository) {
        Assert.notNull(listadoPreguntasRepository, "listadoPreguntasRepository no debe ser null");
        this.listadoPreguntasRepository = listadoPreguntasRepository;
    }

    @Override
    public List<Pregunta> findPreguntas(List<Integer> idCursos) {
        return listadoPreguntasRepository.findPreguntas(idCursos);
    }
}
