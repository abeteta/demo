package com.bs.service.impl;

import com.bo.Area;
import com.bo.Curso;
import com.bs.service.CursoService;
import com.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 10/21/17
 */
@Service
public class CursoServiceImpl implements CursoService{

    private CursoRepository cursoRepository;

    @Autowired
    public CursoServiceImpl(CursoRepository cursoRepository) {
        Assert.notNull(cursoRepository, "videoRepository no debe ser null");
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso findOne(Integer id) {
        return cursoRepository.findOne(id);
    }

}
