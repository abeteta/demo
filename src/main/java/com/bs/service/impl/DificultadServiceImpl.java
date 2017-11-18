package com.bs.service.impl;

import com.bo.Curso;
import com.bo.Dificultad;
import com.bs.service.DificultadService;
import com.repository.CursoRepository;
import com.repository.DificultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/18/17
 */
@Service
public class DificultadServiceImpl implements DificultadService {

    private DificultadRepository dificultadRepository;

    @Autowired
    public DificultadServiceImpl(DificultadRepository dificultadRepository) {
        Assert.notNull(dificultadRepository, "dificultadRepository no debe ser null");
        this.dificultadRepository = dificultadRepository;
    }

    @Override
    public List<Dificultad> findAll() {
        return dificultadRepository.findAll();
    }

    @Override
    public Dificultad findOne(Integer id) {
        return dificultadRepository.findOne(id);
    }
}
